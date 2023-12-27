package com.example.aggregationapp.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseBody {

    private String responseBody;
    private Date data;

}
