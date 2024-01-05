package com.toiba.quresh.appointments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toiba.quresh.appointments.entity.Appointments;
import com.toiba.quresh.appointments.repository.AppointmentsRepository;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

	@Autowired
	private AppointmentsRepository repository;

	@Override
	public Appointments createAppointment(Appointments appointments) {
		return repository.save(appointments);
	}

	@Override
	public Appointments readAppointment(Long appoinmentId) {
		Optional<Appointments> optional = repository.findById(appoinmentId);
		return optional.get();
	}

	@Override
	public Appointments updateAppointment(Long appointmentId, Appointments appointments) {
		Optional<Appointments> optional = repository.findById(appointmentId);
		Appointments appointmentFromDB = optional.get();
		appointmentFromDB.setAppointmentDate(appointments.getAppointmentDate());
		appointmentFromDB.setAppointmentTime(appointments.getAppointmentTime());
		appointmentFromDB.setDuration(appointments.getDuration());
		appointmentFromDB.setPatientName(appointments.getPatientName());
		appointmentFromDB.setPurpose(appointments.getPurpose());
		return repository.save(appointmentFromDB);
	}

	@Override
	public String deleteAppointment(Long appoinmentId) {
		repository.deleteById(appoinmentId);
		return "Deleted";
	}

	@Override
	public List<Appointments> readAppointmentsFromTo(String start, String end) {
		return repository.findByAppointmentDateBetween(start, end);
	}

}
