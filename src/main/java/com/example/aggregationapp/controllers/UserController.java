package com.example.aggregationapp.controllers;

import com.example.aggregationapp.repo.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserController {

    @PostMapping("/getUser")
    public ResponseEntity<?> getUser(@RequestParam Integer id) {
        String user = UserRepo.getUser(id);
        log.info("Get user " + user);
        String jsonResponse = "{\"user_data\": \"User " + user + "had been returned\"}";
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);

    }

}
