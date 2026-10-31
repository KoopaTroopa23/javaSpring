package com.example.javaspring;

import org.springframework.stereotype.Service;

// @Service marks this as a Spring-managed bean (like @Component,
// but signals "this holds business logic" by convention)
@Service
public class Calculator {

    // final = this field can only be set once, in the constructor,
    // and never reassigned afterward
    private final Greeter greeter;

    // Constructor injection: Spring sees Calculator needs a Greeter,
    // finds the @Component-managed Greeter instance, and passes it in here automatically
    public Calculator(Greeter greeter) {
        this.greeter = greeter; // stores the injected Greeter for use in other methods
    }

    public int add(int a, int b) {
        return a + b; // pure logic, no dependency on anything else — easy to test directly
    }

    public String greetAndAdd(int a, int b) {
        // calls the injected Greeter's method, then calls add() on itself,
        // and combines both into one string
        return greeter.greet() + " Result: " + add(a, b);
    }
}