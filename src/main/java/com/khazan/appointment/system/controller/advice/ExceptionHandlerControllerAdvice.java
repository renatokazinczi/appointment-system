package com.khazan.appointment.system.controller.advice;

import com.khazan.appointment.system.dto.error.ErrorResponseDetails;
import com.khazan.appointment.system.dto.error.ErrorResponse;
import com.khazan.appointment.system.dto.exception.MissingTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(
            HttpServletRequest httpServletRequest,
            BadCredentialsException exception
    ) {
        log.info(
                "Caught exception={} with message={}",
                exception.getClass().getName(),
                exception.getMessage(),
                exception
        );
        return buildErrorResponse(exception.getMessage(), httpServletRequest, UNAUTHORIZED);
    }

    @ExceptionHandler({ ExpiredJwtException.class })
    public ResponseEntity<ErrorResponse> handleExpiredJwtException(
            ExpiredJwtException exception,
            HttpServletRequest httpServletRequest
    ) {
        log.info(
                "Caught exception={} with message={}",
                exception.getClass().getName(),
                exception.getMessage(),
                exception
        );
        return buildErrorResponse("Token was expired!", httpServletRequest, UNAUTHORIZED);
    }

    @ExceptionHandler({ MissingTokenException.class })
    public ResponseEntity<ErrorResponse> handleMissingJwtException(
            MissingTokenException exception,
            HttpServletRequest httpServletRequest
    ) {
        log.info(
                "Caught exception={} with message={}",
                exception.getClass().getName(),
                exception.getMessage(),
                exception
        );
        return buildErrorResponse(exception.getMessage(), httpServletRequest, UNAUTHORIZED);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(
            AccessDeniedException exception,
            HttpServletRequest httpServletRequest
    ) {
        log.info(
                "Caught exception={} with message={}",
                exception.getClass().getName(),
                exception.getMessage(),
                exception
        );
        return buildErrorResponse(exception.getMessage(), httpServletRequest, UNAUTHORIZED);
    }

    private static ResponseEntity<ErrorResponse> buildErrorResponse(
            String message,
            HttpServletRequest request,
            HttpStatus status
    ) {
        ErrorResponse errorResponse = getErrorResponseBuilder(message, status)
                .details(new ErrorResponseDetails(request.getMethod(), request.getServletPath()))
                .build();
        return ResponseEntity.status(status).body(errorResponse);
    }

    private static ErrorResponse.ErrorResponseBuilder getErrorResponseBuilder(String message, HttpStatus status) {
        return ErrorResponse.builder()
                .error(status.getReasonPhrase())
                .message(message)
                .status(status.value())
                .timestamp(ZonedDateTime.now());
    }
}
