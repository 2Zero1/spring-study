package com.example.test.controller;

import com.example.test.application.GreetingService;
import com.example.test.dto.GreetingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;


    @GetMapping("/hello")
    public GreetingDto hello (
            @RequestParam(required = false) String name
    ){
//        greetingServce = new GreetingService();
        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setName("YH");
        greetingDto.setMessage(greetingService.getMessage(name));
        return greetingDto;

    }


}
