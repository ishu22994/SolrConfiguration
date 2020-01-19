package com.example.demoSpringSolr.controller;


import com.example.demoSpringSolr.entity.Employee;
import com.example.demoSpringSolr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void addEmployee(){

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Ishit",new String[]{"Ahmedabad","E/1"}));

        employees.add(new Employee(2,"Ekta",new String[]{"GAndhinagar","E/1"}));

        employees.add(new Employee(3,"Abhi",new String[]{"Vadodara","E/1"}));

        employeeRepository.saveAll(employees);
    }


    //it will give the liast of JSON objects
    @GetMapping("/getAll")
    public Iterable<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    //It will give the perticular one JSON Object to the front end
    @GetMapping("/getEmployee/{name}")
    public Employee getEmployee(@PathVariable String name){
        return employeeRepository.findByName(name);
    }

}
