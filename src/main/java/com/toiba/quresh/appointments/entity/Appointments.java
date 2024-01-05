package com.toiba.quresh.appointments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Appointments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appoinmentId;
	private String appointmentDate;
	private String appointmentTime;
	private Integer duration;
	private String patientName;
	private String purpose;

}
