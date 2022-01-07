package com.asml.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
@NamedQuery(name="Pet.findall",query = "select e from Pet e ")
@NamedQuery(name="Pet.findbytype",query = "select e from Pet e where e.type=:type")
@Table(name = "Pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pet_id;
	private String name;
	private String type;
	private int age;
	@ManyToOne
	@JoinColumn(name = "owner_name",referencedColumnName = "owner_name")
	private Owner owner;
	@ManyToMany(mappedBy = "pets")
	private Set<Vet> vets=new HashSet<>();

}
