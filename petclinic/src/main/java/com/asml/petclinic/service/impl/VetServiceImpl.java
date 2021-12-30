package com.asml.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.asml.petclinic.model.Pet;
import com.asml.petclinic.model.Vet;
import com.asml.petclinic.repository.impl.PetDaoImpl;
import com.asml.petclinic.repository.impl.VetDaoImpl;
import com.asml.petclinic.service.PetService;
import com.asml.petclinic.service.VetService;

public class VetServiceImpl implements VetService {
	
	@Autowired
	VetDaoImpl vetDaoImpl;

	@Override
	public List<Vet> get() {
		return vetDaoImpl.getAll();
	}

	@Override
	public List<Vet> findByName(String name) {
 
		return vetDaoImpl.findByVetName(name);
	}
	
	

}
