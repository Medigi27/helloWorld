package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Controller controller;

    private String HELLO_WORLD = "Hello world";

    @Test
     public void printHelloWorldTest() {
        assertEquals(
                controller.printHelloWorld().getStatusCode(),
                new ResponseEntity<>(HELLO_WORLD, HttpStatus.OK).getStatusCode());
        assertEquals(
                controller.printHelloWorld().getBody(),
                HELLO_WORLD
        );
    }

    @Test
    public void helloWorldShouldReturnDefaultMessage() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello world");
    }

}
