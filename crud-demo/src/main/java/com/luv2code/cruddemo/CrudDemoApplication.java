package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	//executed after the Spring Bean hajs been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			System.out.println("Hello World");
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
		};

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("John","Doe","pauldoe@luv2code.com");
		Student tempStudent2 = new Student("Jake","Doe","johndoe@luv2code.com");
		Student tempStudent3 = new Student("Justin","Doe","justindoe@luv2code.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Doe","pauldoe@luv2code.com");

		//save the student object
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student. Generated id: " + tempStudent.getId());
	}

}
