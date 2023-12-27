package com.example.aggregationapp.repo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserRepo {

    private static HashMap<Integer, String> userHashMap = new HashMap<>();

    public static String saveUser(Integer id, String userName) {
        userHashMap.putIfAbsent(id, userName);
        return userName + " had been putted";
    }

    public static String getUser(Integer id) {
        return userHashMap.get(id) + "Get Data User";
    }

}
