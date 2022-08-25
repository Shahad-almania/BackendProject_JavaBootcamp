package com.example.invitation_card_projectbackend.Data_Transfer_Object;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ApiResponse {
    private String message;
    private Integer status;
}
