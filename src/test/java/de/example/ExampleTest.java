package de.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExampleTest {

    @Test
    public void testHello() {
        assertEquals("Hello Tester", new Example().sayHello("Tester"));
    }

}
