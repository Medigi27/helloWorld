package com.example.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private String HELLO_WORLD = "Hello world";

    @GetMapping(value = "/")
    public ResponseEntity printHelloWorld() {
        ResponseEntity responseEntity = new ResponseEntity<>(HELLO_WORLD, HttpStatus.OK);
        return responseEntity;


    }
}
