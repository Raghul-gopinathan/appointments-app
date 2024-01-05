package com.toiba.quresh.appointments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toiba.quresh.appointments.entity.Appointments;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {

	List<Appointments> findByAppointmentDateBetween(String start, String end);

}
