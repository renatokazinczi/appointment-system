package com.khazan.appointment.system.service.appointment;

import com.khazan.appointment.system.dao.model.appointment.Appointment;
import com.khazan.appointment.system.dto.CreateAppointmentDto;
import com.khazan.appointment.system.dto.PagebleDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentAssembler {

    public Appointment toEntity(CreateAppointmentDto createAppointmentDto) {
        return Appointment.builder()
                .userId(createAppointmentDto.userId())
                .title(createAppointmentDto.title())
                .day(createAppointmentDto.day())
                .startTime(createAppointmentDto.startTime())
                .endTime(createAppointmentDto.endTime())
                .build();
    }

    public PagebleDto<List<Appointment>> toPagebleDto(Page<Appointment> appointmentsPage) {
        Integer nextPageNumber = appointmentsPage.hasNext() ? appointmentsPage.nextPageable().getPageNumber() : null;
        Integer previousPageNumber = appointmentsPage.hasPrevious() ? appointmentsPage.previousPageable().getPageNumber() : null;

        return new PagebleDto<>(
                appointmentsPage.getNumber(),
                appointmentsPage.getTotalElements(),
                appointmentsPage.getTotalPages(),
                nextPageNumber,
                previousPageNumber,
                appointmentsPage.getContent()
        );
    }
}
