package com.example.test.controller;

import com.example.test.application.GreetingService;
import com.example.test.dto.Greeting;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class GreetingController {

    @Autowired
    private GreetingService greetingServce;


    @GetMapping("/hello")
    public Greeting hello (
            @RequestParam(required = false) String name
    ){
        Greeting greeting = new Greeting();
        greeting.setName("YH");
        greeting.setMessage(greetingServce.getMessage(name));
        return greeting;

    }


}
