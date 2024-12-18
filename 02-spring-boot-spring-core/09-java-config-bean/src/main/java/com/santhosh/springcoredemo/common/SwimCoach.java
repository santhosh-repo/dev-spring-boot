package com.santhosh.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("inside no-arg constructor " + getClass().getSimpleName()
        );
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
