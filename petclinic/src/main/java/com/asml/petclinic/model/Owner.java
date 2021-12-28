package com.asml.petclinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer owner_id;
	private String owner_name;
	private Long num;
	private String village;
	private String state;
	private Long pincode;
	@OneToMany(cascade =CascadeType.ALL,fetch=FetchType.EAGER )
	private List<Pet> pets;
	
	@OneToMany(cascade =CascadeType.ALL)
	private List<Appointment> appointment;

}
