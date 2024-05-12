package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //Inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    //Expose a new endpoint: teaminfo
    @GetMapping("/teaminfo")
    public String teamInfo(){
        return "Coach Name:" + coachName + ", Team Name:"+ teamName;
    }



    //expose "/" endpoint and return hello world
    @GetMapping("/")
    public String sayHello(){
        return "Hello world!";
    }

    @GetMapping("/workout")
    public String workoutDaily(){
        return "Health is wealth";
    }

}
