package com.santhosh.aopdemo;

import com.santhosh.aopdemo.dao.AccountDAO;
import com.santhosh.aopdemo.dao.MemberShipDAO;
import com.santhosh.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberShipDAO memberShipDAO,
                                               TrafficFortuneService theTrafficFortuneService) {
        return runner -> {
            //demoTheBeforeAdvice(theAccountDAO, memberShipDAO);
            //demoTheAfterReturningAdvice(theAccountDAO);
            //demoTheAfterThrowingAdvice(theAccountDAO);
           // demoTheAfterAdvice(theAccountDAO);

            //demoTheAroundAdvice(theTrafficFortuneService);

            demoTheAroundAdviceHandleException(theTrafficFortuneService);

        };
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

        boolean tripWire = true;

        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\nMain Program: AroundDemoApp");

        String data = theTrafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program: Caught exception " + exc);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");

        System.out.println("----");

        System.out.println(theAccounts);
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program: Caught exception " + exc);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");

        System.out.println("----");

        System.out.println(theAccounts);
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");

        System.out.println("----");

        System.out.println(theAccounts);
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MemberShipDAO memberShipDAO) {
        Account account = new Account();
        account.setName("Santhosh");
        account.setLevel("Platinum");
        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();
        theAccountDAO.setName("foobar");
        theAccountDAO.getName();
        theAccountDAO.setServiceCode("silver");
        theAccountDAO.getServiceCode();

        // call the membership business method
        memberShipDAO.addSillyMember();
        memberShipDAO.goToSleep();
    }


}
