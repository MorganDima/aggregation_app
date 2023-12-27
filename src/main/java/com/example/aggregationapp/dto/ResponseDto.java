package com.example.aggregationapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDto {

    public Integer responseStatus;
    public List<ResponseBody> responseBody;
}
