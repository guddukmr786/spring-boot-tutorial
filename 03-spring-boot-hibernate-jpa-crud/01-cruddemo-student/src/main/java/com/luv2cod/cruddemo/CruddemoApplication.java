package com.luv2cod.cruddemo;

import com.luv2cod.cruddemo.dao.StudentDAO;
import com.luv2cod.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		//Java lambda expression
		return runner -> {
			/*
			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
			*/

            deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll(); 
		System.out.println("Deleted row count: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 7;
		System.out.println("Deleting studet id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("getting sudent with id:"+studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to Guddu
		System.out.println("Updating student...");
		myStudent.setFirstName("John");

		//update the student
		studentDAO.update(myStudent);

		//display the updated record
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Sir");
		//display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of student
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating a student object....");
		Student tempStudent = new Student("Khan","sir","khan@ibm.com");
		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. generated id:"+theId);

		//retrieve the student based on the id
		System.out.println("Retrieving student with id:"+ theId);
		Student myStudent = studentDAO.findById(theId);

		//display the student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 students");
		Student tempStudent1= new Student("Guddu","Kumar","guddu@ibm.com");
		Student tempStudent2= new Student("Prabhakar","Kumar","pk458@gmail.com");
		Student tempStudent3= new Student("Rajesh","Kumar","rajesh@gmail.com");

		System.out.println("Saving all three students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("Wow finally we saved multiple students");
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
