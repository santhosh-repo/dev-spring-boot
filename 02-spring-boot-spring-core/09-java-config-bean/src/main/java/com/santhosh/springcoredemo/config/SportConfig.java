package com.santhosh.springcoredemo.config;

import com.santhosh.springcoredemo.common.Coach;
import com.santhosh.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
