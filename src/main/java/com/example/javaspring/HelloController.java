package com.example.javaspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController = a Spring bean that answers web requests;
// whatever each method returns is sent back as the response body
@RestController
public class HelloController {

    private final Calculator calculator;

    // Constructor injection again: Spring passes in the Calculator bean
    public HelloController(Calculator calculator) {
        this.calculator = calculator;
    }

    // Answers GET http://localhost:9000/  (the "home page")
    // Without this, visiting the bare URL gives a 404 Whitelabel Error Page
    @GetMapping("/")
    public String home() {
        return "App is running! Try /hello or /hello?a=4&b=6";
    }

    // Answers GET http://localhost:9000/hello?a=2&b=3
    // @RequestParam reads a and b from the URL (defaults used if missing)
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "2") int a,
                        @RequestParam(defaultValue = "3") int b) {
        return calculator.greetAndAdd(a, b);
    }
}
