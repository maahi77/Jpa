package com.asml.petclinic.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.asml.petclinic.model.Owner;
import com.asml.petclinic.model.Pet;

@Repository
public class PetDaoImpl {
	
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");


	public List<Pet> getAll() {
    
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Pet> namedQuery = manager.createNamedQuery("Pet.findall", Pet.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}


	public List<Pet> findByBreed(String type) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Pet> namedQuery = manager.createNamedQuery("Pet.finbytype", Pet.class);
        namedQuery.setParameter("type",type);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());
   
		
	}
	
	
	

}
