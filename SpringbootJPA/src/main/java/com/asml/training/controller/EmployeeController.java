package com.asml.training.controller;

import com.asml.training.entity.Employee;
import com.asml.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(name="hello", path = "/hello")
    public String getEmployee(){
        return "hello";
    }

    @GetMapping(name = "getAll", path="/getAll")
    public List<Employee> getAll(){
        service.add(new Employee(1L, "Sunita"));
        service.add(new Employee(2L, "Bindu"));
        service.add(new Employee(3L, "Mahendra"));
       return service.get();
    }

    @GetMapping(name="welcome", path = "/")
    public String startup(){
        return "welcome";
    }
}
