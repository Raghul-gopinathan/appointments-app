package com.toiba.quresh.appointments.service;

import java.util.List;

import com.toiba.quresh.appointments.entity.Appointments;

public interface AppointmentsService {
	public Appointments createAppointment(Appointments appointments);

	public Appointments readAppointment(Long appoinmentId);

	public Appointments updateAppointment(Long appoinmentId, Appointments appointments);

	public String deleteAppointment(Long appoinmentId);

	List<Appointments> readAppointmentsFromTo(String start, String end);
}
