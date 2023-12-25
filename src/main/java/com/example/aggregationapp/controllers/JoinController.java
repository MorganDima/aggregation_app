package com.example.aggregationapp.controllers;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class JoinController {

    @PostMapping("/aggregation_app")
    private static String getData() {

        log.info("Hello from first controller");

        return "Hello from aggregation API";
    }

}