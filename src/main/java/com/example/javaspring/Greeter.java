package com.example.javaspring;

import org.springframework.stereotype.Component;

// @Component tells Spring "create and manage one instance of this class"
// so it can be handed (injected) into anything that needs it
@Component
public class Greeter {
    public String greet() {
        return "Hello!"; // just returns a fixed string — the real logic we're wrapping
    }
}