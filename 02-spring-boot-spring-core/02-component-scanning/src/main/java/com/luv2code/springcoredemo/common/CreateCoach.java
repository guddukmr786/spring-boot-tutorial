package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CreateCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 20 minutes!!!!!";
    }
}
