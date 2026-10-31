package com.example.javaspring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Tells JUnit 5 to activate Mockito's engine for this test class —
// without this, @Mock and @InjectMocks below do nothing
@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    // Creates a fake (mock) Greeter — it has the same methods as the real one,
    // but none of them do anything unless you explicitly tell them to (via when(...))
    @Mock
    private Greeter greeter;

    // Creates a real Calculator instance, and automatically injects the @Mock
    // Greeter above into its constructor — so Calculator doesn't know it's fake
    @InjectMocks
    private Calculator calculator;

    // @Test marks this method as a test case JUnit will run
    @Test
    void add_returnsSum() {
        // calls the real add() method (no mocking needed, it has no dependencies)
        // and asserts the result matches what we expect; test fails if it doesn't
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void greetAndAdd_usesMockedGreeting() {
        // Tells the mock Greeter: "when greet() is called, return 'Yo!' instead of running real code"
        when(greeter.greet()).thenReturn("Yo!");

        // Calls the method under test — internally it calls the mocked greet()
        // and the real add(), then combines them
        String result = calculator.greetAndAdd(2, 3);

        // Verifies the combined output matches exactly what we expect,
        // proving greetAndAdd() correctly used the greeting + the sum
        assertEquals("Yo! Result: 5", result);
    }
}