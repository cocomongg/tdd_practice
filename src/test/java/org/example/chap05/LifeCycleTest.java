package org.example.chap05;

import org.junit.jupiter.api.*;

public class LifeCycleTest {
    public LifeCycleTest() {
        System.out.println("call LifeCycleTest constructor");
    }

    @BeforeAll
    static void init() {
        System.out.println("call @BeforeAll method");
    }

    @BeforeEach
    void setup() {
        System.out.println("call @BeforeEach method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("call @AfterAll method");
    }

    @AfterEach
    void teardown() {
        System.out.println("call @AfterEach method");
    }

    @Test
    void a() {
        System.out.println("call @Test method a");
    }

    @Test
    void b() {
        System.out.println("call @Test method b");
    }
}
