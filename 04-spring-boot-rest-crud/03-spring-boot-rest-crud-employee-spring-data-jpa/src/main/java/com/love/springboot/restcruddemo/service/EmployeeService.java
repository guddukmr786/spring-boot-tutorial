package com.love.springboot.restcruddemo.service;

import com.love.springboot.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //define the find all method
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
