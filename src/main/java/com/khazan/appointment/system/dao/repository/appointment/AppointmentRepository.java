package com.khazan.appointment.system.dao.repository.appointment;

import com.khazan.appointment.system.dao.model.appointment.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends MongoRepository<Appointment, UUID> {

    Page<Appointment> findByUserId(UUID userId, Pageable page);
    Page<Appointment> findByDay(LocalDate day, Pageable page);
    List<Appointment> findAllByDayBetween(LocalDate startDate, LocalDate endDate, Sort sort);
}
