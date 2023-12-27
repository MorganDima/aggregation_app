package com.example.aggregationapp.controllers;

import com.example.aggregationapp.dto.ResponseBody;
import com.example.aggregationapp.dto.ResponseDto;
import com.example.aggregationapp.repo.UserRepo;
import com.example.aggregationapp.services.JsonConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController {


    public final JsonConverter jsonConverter;

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(@RequestParam Integer id) throws InterruptedException {
        String user = UserRepo.getUser(id);
        log.info("Get user data " + user);

        String objectName = "Get user data ".concat(user.toUpperCase());

        ResponseBody responseBody1 = new ResponseBody(objectName, new Date());
        Thread.sleep(1000);
        ResponseBody responseBody2 = new ResponseBody(objectName + " register", new Date());

        List<ResponseBody> responseBodyList = new ArrayList<>();
        responseBodyList.add(responseBody1);
        responseBodyList.add(responseBody2);

        ResponseDto responseDto = new ResponseDto(HttpStatus.OK.value(), responseBodyList);

        String jsonResponse = jsonConverter.convertObjectToJson(responseDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(jsonResponse, headers, HttpStatus.OK);

    }
}