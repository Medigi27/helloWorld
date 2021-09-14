package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTests {
    private String HELLO_WORLD = "Hello world";

    @Test
    void printHelloWorldTest() {
        Controller controller = new Controller();
        assertEquals(
                controller.printHelloWorld().getStatusCode(),
                new ResponseEntity<>(HELLO_WORLD, HttpStatus.OK).getStatusCode());
        assertEquals(
                controller.printHelloWorld().getBody(),
                HELLO_WORLD
        );
    }
}
