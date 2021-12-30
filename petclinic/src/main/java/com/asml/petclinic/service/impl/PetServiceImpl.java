package com.asml.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.asml.petclinic.model.Pet;
import com.asml.petclinic.repository.impl.PetDaoImpl;
import com.asml.petclinic.service.PetService;

public class PetServiceImpl implements PetService {
	
	@Autowired
	PetDaoImpl petDaoImpl;

	@Override
	public List<Pet> get() {
		return petDaoImpl.getAll();
	}

	@Override
	public List<Pet> findByType(String type) {
 
		return petDaoImpl.findByBreed(type);
	}
	
	

}
