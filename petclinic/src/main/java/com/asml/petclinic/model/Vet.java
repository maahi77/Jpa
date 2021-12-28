package com.asml.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Vet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vet_id;
	private String name;
	private Long phnum;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "vets_pets",joinColumns = { @JoinColumn(name="vets_id")},
	inverseJoinColumns = { @JoinColumn(name="pets_id")}
	
			)
	private Set<Pet> pets=new HashSet<>();
	
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER )
	private Set<Appointment> appointments;


	

}

