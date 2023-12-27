package com.example.aggregationapp.controllers;


import com.example.aggregationapp.dto.UserDto;
import com.example.aggregationapp.repo.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class JoinController {

    @PostMapping("/aggregation_app")
    public HttpStatusCode getData() {
        log.info("Hello from Aggregation APP, get data");

        String jsonResponse = "{\"message\": \"Hello from Aggregation APP\"}";
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse).getStatusCode();
    }

    @PostMapping("/aggregation_app2")
    public ResponseEntity<?> getData2() {

        log.info("Hello from Aggregation APP, get data");

        String jsonResponse = "{\"message\": \"Hello from Aggregation APP\"}";
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> postData(@RequestBody UserDto userDto) {
        String user = UserRepo.saveUser(1, userDto.getFullName());
        log.info("User dto " + userDto.toString());
        String jsonResponse = "{\"message\": \"User " + userDto.getFullName() + "had been created\"}";
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @PostMapping("/register2")
    public HttpStatusCode postData2(@RequestBody UserDto userDto) {

        log.info("User dto " + userDto.toString());
        String jsonResponse = "{\"message\": \"User " + userDto.getFullName() + "had been created\"}";
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse).getStatusCode();
    }
}