package com.example.test.controller;

import com.example.test.application.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(GreetingController.class)
@ActiveProfiles("test")
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @BeforeEach
    public void mockGreetingService() {
        given(greetingService.getMessage(null)).willReturn("Hello");

        given(greetingService.getMessage("YH")).willReturn("Hello, YH");
    }

    @Test
    public void hello() throws Exception {

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    @Test
    public void helloWithName() throws Exception {
        mockMvc.perform(get("/hello").param("name","YH"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, YH")));

    }   @Test
    public void helloWithName2() throws Exception {
        mockMvc.perform(get("/hello").param("name","H"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, H")));

    }

}