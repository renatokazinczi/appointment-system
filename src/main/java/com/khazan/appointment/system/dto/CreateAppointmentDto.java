package com.khazan.appointment.system.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record CreateAppointmentDto(
        @NotNull @FutureOrPresent LocalDate day,
        @NotNull LocalTime startTime,
        @NotNull LocalTime endTime,
        @NotNull String title,
        @NotNull String userId
) { }
