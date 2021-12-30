package com.asml.petclinic.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.asml.petclinic.model.Pet;
import com.asml.petclinic.model.Vet;

@Repository
public class VetDaoImpl {
	
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");


	public List<Vet> getAll() {
    
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Vet> namedQuery = manager.createNamedQuery("Vet.findall", Vet.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}


	public List<Vet> findByVetName(String name) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Vet> namedQuery = manager.createNamedQuery("Vet.finbyvetname", Vet.class);
        namedQuery.setParameter("name",name);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());
		
	}
}