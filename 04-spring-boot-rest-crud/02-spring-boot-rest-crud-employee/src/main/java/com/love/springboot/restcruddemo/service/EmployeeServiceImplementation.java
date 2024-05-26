package com.love.springboot.restcruddemo.service;

import com.love.springboot.restcruddemo.dao.EmployeeDAO;
import com.love.springboot.restcruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImplementation(EmployeeDAO theEmployeeDao){
        employeeDAO = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
