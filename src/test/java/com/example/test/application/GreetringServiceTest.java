package com.example.test.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GreetringServiceTest {


    @SpyBean
    private GreetingService greetingService;



    @BeforeEach
    public void setUp() {
        greetingService = new GreetingService();

    }


    @Test
    public void getMessage() {
        assertThat(greetingService.getMessage(null)).isEqualTo("Hello");
    }

    @Test
    public void getMessageWithName() {
        assertThat(greetingService.getMessage("YH")).isEqualTo("Hello, YH");
    }

}