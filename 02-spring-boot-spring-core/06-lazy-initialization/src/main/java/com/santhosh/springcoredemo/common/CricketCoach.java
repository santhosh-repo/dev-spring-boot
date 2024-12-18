package com.santhosh.springcoredemo.common;

import com.santhosh.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("inside no-arg constructor " + getClass().getSimpleName()
        );
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
