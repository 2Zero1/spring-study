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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(GreetingController.class)
@ActiveProfiles("test")
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean            // 여기에 mockBean을 사용할 경우, GreetingService에서 greetingService를 autoWired 어노테이션을 붙혀도 DI가 안된다.
                        // SpyBean은 greetingService는 이곳에서 call을 하는 코드가 보이지 않아 사용하지 않는것 처럼 보이지만
                        // productService를 삭제하거나 mockBean을 할 경우, GreetingConteller.java에서 greetingService를 인젝션을 받지 못한다.
                        // 쿄드로 보면 이 테스트로 API 레이어의 코드를 실행 시키면, API 레이어의 코드는 service를 의존하고 있다. 그래서 API 레이어에서 serivice를 의존성 주입을 받기 위해서는 이곳에서 spyBean을 사용하여
                        // 스프링에서 관리하는 객체가 생성되도록 해야한다. 만약에 통합으로 실행 한다면 스프링이 모든 @componenet를 다 가져와 관리하는데 이러면 너무 무겁다. 그래서 우리는 API 레이어 테스트만 하기 위해서 @WebMvcTest 를 붙히는데 이러면,
                        //ProductService를 놓치게 된다. spyBean은 해당 객체를 잠입 시켜주고 원래는 실제로 무슨일이 벌어지는지 내부를 파악하거나 조작하는데 쓰지만 여기서는 잠입의 용도로 썼다.
    private GreetingService greetingService;


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
    }

}