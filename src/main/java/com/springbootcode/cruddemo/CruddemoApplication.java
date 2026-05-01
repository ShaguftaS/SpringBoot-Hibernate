package com.springbootcode.cruddemo;

import com.springbootcode.cruddemo.dao.StudentDAO;
import com.springbootcode.cruddemo.entity.Student;
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
		return runner ->{
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			readStudent(studentDAO);

		};
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Daffy","Duck", "daffy@xyz.com");

		//save the student
		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theID = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theID);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: " + theID);
		Student mystudent = studentDAO.findById(theID);

		//display student
		System.out.println("Found the student: " + mystudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("John", "Doe", "john@xyz.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@xyz.com");
		Student tempStudent3 = new Student("Banita", "Applebum", "banita@xyz.com");

		//save the student objects
		System.out.println("Saving the students ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@xyz.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id:  "+ tempStudent.getId());
	}
}
