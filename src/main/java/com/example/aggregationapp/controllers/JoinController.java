package com.example.aggregationapp.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {

    @PostMapping("/aggregation_app")
    private static String getData() {

        return "Hello";
    }

}