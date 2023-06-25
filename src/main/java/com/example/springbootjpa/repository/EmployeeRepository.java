package com.example.springbootjpa.repository;

import com.example.springbootjpa.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
