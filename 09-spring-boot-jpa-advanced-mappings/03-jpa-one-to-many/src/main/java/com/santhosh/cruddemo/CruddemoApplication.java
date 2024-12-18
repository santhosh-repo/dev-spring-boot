package com.santhosh.cruddemo;

import com.santhosh.cruddemo.dao.AppDAO;
import com.santhosh.cruddemo.entity.Course;
import com.santhosh.cruddemo.entity.Instructor;
import com.santhosh.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructorById(appDAO);
			//deleteInstructorById(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructorById(appDAO);
			//updateCourseById(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		appDAO.deleteCourseById(10);
	}

	private void updateCourseById(AppDAO appDAO) {
		int theId = 11;
		Course theCourse = appDAO.findCourseById(theId);
		System.out.println("before update Course::: " + theCourse);
		theCourse.setTitle("Node JS");
		appDAO.update(theCourse);
		System.out.println("Updated Course::: " + theCourse);
	}

	private void updateInstructorById(AppDAO appDAO) {
		int theId = 1;
		Instructor theInstructor = appDAO.findInstructorById(theId);
		theInstructor.setLastName("Donald");
		appDAO.update(theInstructor);
		System.out.println("Updated Instructor::: " + theInstructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		Instructor theInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("theInstructor::: " + theInstructor);
		System.out.println("Courses ::: " + theInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("theInstructor::: " + theInstructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		theInstructor.setCourses(courses);
		System.out.println("Courses ::: " + theInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("theInstructor::: " + theInstructor);
		System.out.println("Courses ::: " + theInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor theInstructor = new Instructor("Santhosh", "Kumar", "santhosh@gmail.com");

		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.youtube.com", "Coding");

		theInstructor.setInstructorDetail(theInstructorDetail);

		Course tempCourse1 = new Course("Java");
		Course tempCourse2 = new Course("Python");

		theInstructor.add(tempCourse1);
		theInstructor.add(tempCourse2);

		appDAO.save(theInstructor);

	}

	private void createInstructor(AppDAO appDAO) {
		Instructor theInstructor = new Instructor("Santhosh", "Kumar", "santhosh@gmail.com");

		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.youtube.com", "Coding");

		theInstructor.setInstructorDetail(theInstructorDetail);
		appDAO.save(theInstructor);
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor theInstructor = appDAO.findInstructorById(1);
		System.out.println(theInstructor);
		System.out.println(theInstructor.getInstructorDetail());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);

	}
}
