package com.khazan.appointment.system.controller;

import com.khazan.appointment.system.dao.model.appointment.Appointment;
import com.khazan.appointment.system.dto.CreateAppointmentDto;
import com.khazan.appointment.system.dto.PagebleDto;
import com.khazan.appointment.system.service.appointment.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<PagebleDto<List<Appointment>>> getAppointments(
            @RequestParam(required = false) LocalDate day,
            @RequestParam(defaultValue = "3") Integer size,
            @RequestParam(defaultValue = "0") Integer page
    ) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsFiltered(day, size, page));
    }

    @GetMapping(path = "/calendar/{date}")
    public ResponseEntity<List<Appointment>> getAppointmentsForCalendar(
            @PathVariable("date") LocalDate date
    ) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForCalendar(date));
    }

    @PostMapping
    public ResponseEntity<String> createAppointment(@RequestBody @Valid CreateAppointmentDto createAppointmentDto) {
        return ResponseEntity.ok(appointmentService.createAppointment(createAppointmentDto));
    }
}
