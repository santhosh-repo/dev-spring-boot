package com.santhosh.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("inside no-arg constructor " + getClass().getSimpleName()
        );
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
