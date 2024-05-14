package com.luv2cod.cruddemo.dao;

import com.luv2cod.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//Specialize annotation for repositories support component scanning
// Translate JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{

    //inject entity manger using constructor injection
    @Autowired
    private EntityManager entityManager;
    public StudentDAOImpl(EntityManager entityManager){
        //define field for entity manager
        this.entityManager = entityManager;
    }

    //implements save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
