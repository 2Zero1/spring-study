package com.example.test.controller;

import com.example.test.application.GreetingService;
import com.example.test.domain.Product;
import com.example.test.dto.Greeting;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;


    @GetMapping("/hello")
    public Greeting hello (
            @RequestParam(required = false) String name
    ){
//        greetingServce = new GreetingService();
        Greeting greeting = new Greeting();
        greeting.setName("YH");
        greeting.setMessage(greetingService.getMessage(name));
        return greeting;

    }


}
