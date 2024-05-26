package com.love.springboot.restcruddemo.dao;

import com.love.springboot.restcruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {
    //define field for entity manager
    private final EntityManager entityManager;
    //setup constructor injection
    @Autowired
    public EmployeeDAOImplementation(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute the query and get the result
        //return the results set
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        //return employee
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save the employee
        //return the updated or saved employee
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //remove employee
        entityManager.remove(theEmployee);
    }
}
