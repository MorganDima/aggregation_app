package com.example.aggregationapp.controllers;


import com.example.aggregationapp.dto.ResponseBody;
import com.example.aggregationapp.dto.ResponseDto;
import com.example.aggregationapp.dto.UserDto;
import com.example.aggregationapp.repo.UserRepo;
import com.example.aggregationapp.services.JsonConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RegisterController {


    public final JsonConverter jsonConverter;

    @PostMapping("/register")
    public ResponseEntity<?> postData(@RequestBody UserDto userDto) throws InterruptedException {

        String userName = UserRepo.saveUser(Integer.parseInt(userDto.getT_zeut()), userDto.getFullName());
        log.info("User dto " + userName);
        String objectName = "User ".concat(userName.toUpperCase()).concat(" had been created");


        ResponseBody responseBody1 = new ResponseBody(objectName, new Date());
        Thread.sleep(1000);
        ResponseBody responseBody2 = new ResponseBody(objectName+" register", new Date());

        List<ResponseBody> responseBodyList = new ArrayList<>();
        responseBodyList.add(responseBody1);
        responseBodyList.add(responseBody2);

        ResponseDto responseDto = new ResponseDto(HttpStatus.OK.value(), responseBodyList);
        String jsonResponse = jsonConverter.convertObjectToJson(responseDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(jsonResponse, headers, HttpStatus.OK);
    }

    @PostMapping("/register2")
    public HttpStatusCode postData2(@RequestBody UserDto userDto) {

        log.info("User dto " + userDto.toString());
        String jsonResponse = "{\"message\": \"User " + userDto.getFullName() + "had been created\"}";
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse).getStatusCode();
    }


    //============================================================================================================
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


}