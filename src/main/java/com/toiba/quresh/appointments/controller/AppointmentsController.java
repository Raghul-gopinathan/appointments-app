package com.toiba.quresh.appointments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toiba.quresh.appointments.entity.Appointments;
import com.toiba.quresh.appointments.service.AppointmentsServiceImpl;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

	@Autowired
	private AppointmentsServiceImpl service;

	@PostMapping("/create")
	public ResponseEntity<Appointments> createAppointment(@RequestBody Appointments appoinment) {
		return new ResponseEntity<Appointments>(service.createAppointment(appoinment), HttpStatus.CREATED);
	}

	@GetMapping("/read/{appointmentId}")
	public ResponseEntity<Appointments> readAppointment(@PathVariable Long appointmentId) {
		return new ResponseEntity<Appointments>(service.readAppointment(appointmentId), HttpStatus.OK);
	}
	
	@GetMapping("/read/from/{start}/to/{end}")
	public ResponseEntity<List<Appointments>> readAppointmentsFromTo(@PathVariable String start, @PathVariable String end) {
		return new ResponseEntity<List<Appointments>>(service.readAppointmentsFromTo(start,end), HttpStatus.OK);
	}

	@PutMapping("/update/{appointmentId}")
	public ResponseEntity<Appointments> updateAppointment(@PathVariable Long appointmentId,
			@RequestBody Appointments appoinment) {
		return new ResponseEntity<Appointments>(service.updateAppointment(appointmentId, appoinment), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId) {
		return new ResponseEntity<String>(service.deleteAppointment(appointmentId), HttpStatus.OK);
	}

}
