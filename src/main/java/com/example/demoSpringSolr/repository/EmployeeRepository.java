package com.example.demoSpringSolr.repository;

import com.example.demoSpringSolr.entity.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface EmployeeRepository extends SolrCrudRepository<Employee,Integer> {

    Employee findByName(String name);
}
