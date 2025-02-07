package com.project.connection.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/test")
    public ResponseEntity<String> testMethod()
    {
        return new ResponseEntity<>("test method...", HttpStatus.OK);
    }
}
