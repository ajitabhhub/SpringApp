package com.ajitabh;

import org.junit.jupiter.api.*;

public class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        greeting = new Greeting();
        System.out.println(greeting.helloWorld());
    }

    @Test
    void helloWorldName() {
        greeting = new Greeting();
        System.out.println(greeting.helloWorld("Ajitabh"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each...");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After Class!  I am only called once!");
    }
}
