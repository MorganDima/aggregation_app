package com.example.aggregationapp.controllers;


import com.example.aggregationapp.dto.UserDto;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class JoinController {

    @PostMapping("/aggregation_app")
    public ResponseEntity<String> getData() {

        log.info("Hello from Aggregation APP, get data");

        String jsonResponse = "{\"message\": \"Hello from Aggregation APP\"}";

        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<String> postData(@RequestBody UserDto userDto) {


        log.info("User dto " + userDto.toString());

        String jsonResponse = "{\"message\": \"User " + userDto.getUserName() + "had been created\"}";

        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);

    }
}