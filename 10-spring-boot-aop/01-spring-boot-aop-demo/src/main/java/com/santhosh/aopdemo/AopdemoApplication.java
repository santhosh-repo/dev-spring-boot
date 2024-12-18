package com.santhosh.aopdemo;

import com.santhosh.aopdemo.dao.AccountDAO;
import com.santhosh.aopdemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,  MemberShipDAO memberShipDAO){
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, memberShipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MemberShipDAO memberShipDAO) {
		Account account = new Account();

		theAccountDAO.addAccount(account, true);
		theAccountDAO.doWork();

		// call the membership business method
		memberShipDAO.addSillyMember();
		memberShipDAO.goToSleep();
	}


}
