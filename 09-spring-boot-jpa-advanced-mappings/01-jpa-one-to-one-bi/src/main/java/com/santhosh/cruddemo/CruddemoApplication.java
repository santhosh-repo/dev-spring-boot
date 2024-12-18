package com.santhosh.cruddemo;

import com.santhosh.cruddemo.dao.AppDAO;
import com.santhosh.cruddemo.entity.Instructor;
import com.santhosh.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
			//findInstructorById(appDAO);
			//deleteInstructorById(appDAO);
		};
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
