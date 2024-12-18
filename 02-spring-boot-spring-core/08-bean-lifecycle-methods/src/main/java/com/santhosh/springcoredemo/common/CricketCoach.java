package com.santhosh.springcoredemo.common;

import com.santhosh.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("inside no-arg constructor " + getClass().getSimpleName()
        );
    }
    // define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("CricketCoach: inside method doMyStartupStuff");
    }
    // define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("CricketCoach: inside method doMyCleanupStuff");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
