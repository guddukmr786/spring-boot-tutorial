package com.luv2cod.cruddemo;

import com.luv2cod.cruddemo.dao.StudentDAO;
import com.luv2cod.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		//Java lambda expression
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("paul", "Doe", "paul@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		try {
			studentDAO.save(tempStudent);
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
        //display the id of saved student
		System.out.println("Saved student Generated id: "+ tempStudent.getId());
	}
}
