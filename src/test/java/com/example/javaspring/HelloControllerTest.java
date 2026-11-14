package com.example.javaspring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

// Starts the full app (real Greeter + Calculator) and sends fake HTTP
// requests through MockMvc, so no browser or open port is needed
@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void home_returnsRunningMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("App is running! Try /hello or /hello?a=4&b=6"));
    }

    @Test
    void hello_usesDefaults() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Kevin Result: 5"));
    }

    @Test
    void hello_addsQueryParams() throws Exception {
        mockMvc.perform(get("/hello").param("a", "4").param("b", "6"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Kevin Result: 10"));
    }
}
