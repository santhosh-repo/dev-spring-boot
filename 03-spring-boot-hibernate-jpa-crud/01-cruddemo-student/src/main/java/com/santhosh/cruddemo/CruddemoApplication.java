package com.santhosh.cruddemo;

import com.santhosh.cruddemo.dao.StudentDAO;
import com.santhosh.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			 createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int deletedRecords = studentDAO.deleteAll();
		System.out.println("Deleted Records: "+deletedRecords);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;

		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student by id
		int studentId = 1;
		System.out.println("Retrieving student with id: " + studentId);
		Student student = studentDAO.findById(studentId);
		System.out.println("Retrieved student: " + student);

		// change lastname to babu
		student.setLastName("Babu");

		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student: " + studentDAO.findById(studentId));
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Donald");

		// display the students
		for(Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students

		List<Student> studentList = studentDAO.findAll();

		// display the students
		for(Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating a new Student Object");
		Student student = new Student("Warner", "David", "davidwarner@gmail.com");

		// save the student
		System.out.println("Saving a new Student Object");
		studentDAO.save(student);

		System.out.println("Saved Student. Generated id: " + student.getId());

		Student myStudent = studentDAO.findById(student.getId());
		System.out.println("Found the Student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 Student Objects");
		Student tempStudent1 = new Student("Trump", "Donald", "donaldtrump@gmail.com");
		Student tempStudent2 = new Student("Musk", "Elon", "elonmusk@gmail.com");
		Student tempStudent3 = new Student("Joe", "Biden", "joebiden@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved Student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent3.getId());


	}

	private void createStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating a new Student Object");
		Student student = new Student("Santhosh", "Ch", "santhoshcharugundla.dev@gmail.com");

		// save the student
		System.out.println("Saving a new Student Object");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saved Student. Generated id: " + student.getId());


	}


}
