package com.asml.training.service;

import com.asml.training.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    void add(Employee e);
    void update(Employee e);
    List<Employee> get();
}
