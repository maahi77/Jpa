package com.asml.training.repository.impl;

import com.asml.training.entity.Employee;
import com.asml.training.repository.AbstarctDao;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl extends AbstarctDao<Employee> {
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
    public void add(Employee e){
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(e);
        tx.commit();
    }

    public void update(Employee e){
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.merge(e);
    }
    
    public List<Employee> findAll(){
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> namedQuery = manager.createNamedQuery("Employee.findAll", Employee.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());
    }
}
