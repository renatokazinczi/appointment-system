package com.khazan.appointment.system.service.appointment;

import com.khazan.appointment.system.dao.model.appointment.Appointment;
import com.khazan.appointment.system.dao.repository.appointment.AppointmentRepository;
import com.khazan.appointment.system.dto.CreateAppointmentDto;
import com.khazan.appointment.system.dto.PagebleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentAssembler appointmentAssembler;

    public String createAppointment(CreateAppointmentDto createAppointmentDto) {
        Appointment saved = appointmentRepository.save(appointmentAssembler.toEntity(createAppointmentDto));
        return saved.getId();
    }

    public PagebleDto<List<Appointment>> getAllAppointmentsFiltered(
            LocalDate day,
            Integer size,
            Integer page
    ) {
        Pageable paging = PageRequest.of(page, size, Sort.Direction.ASC, "startTime");
        return appointmentAssembler.toPagebleDto(getAppointments(day, paging));
    }

    public List<Appointment> getAppointmentsForCalendar(LocalDate date) {
        LocalDate startDate = date.with(previousOrSame(MONDAY)).minusDays(1);
        LocalDate endDate = date.with(nextOrSame(SUNDAY)).plusDays(1);

        return appointmentRepository.findAllByDayBetween(startDate, endDate, Sort.by(Sort.Direction.ASC, "day", "startTime"));
    }

    private Page<Appointment> getAppointments(LocalDate day, Pageable paging) {
        if (day == null) {
            return appointmentRepository.findAll(paging);
        } else {
            return appointmentRepository.findByDay(day, paging);
        }
    }
}
