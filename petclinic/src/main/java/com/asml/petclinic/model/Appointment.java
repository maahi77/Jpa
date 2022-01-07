package com.asml.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@NamedQuery(name="Appointment.findall",query = "select e from Appointment e ")
@NamedQuery(name="Appointment.findbyday",query = "select e from Appointment e where e.day=:day")
@Table(name = "Appointments")
public class Appointment {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_id;
	private double price;
	private Integer day;
	private Integer month;
	private Integer year;
	private Integer stime;
	private String  meridian;
	@ManyToOne
	@JoinColumn(name = "owner_name",referencedColumnName = "owner_name")
	private Owner owner;
	@ManyToOne
	@JoinColumn(name = "vet_id")
	private Vet vet;

}

