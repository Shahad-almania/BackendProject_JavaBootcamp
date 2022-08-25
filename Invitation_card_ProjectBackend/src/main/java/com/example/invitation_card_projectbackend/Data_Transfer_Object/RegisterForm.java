package com.example.invitation_card_projectbackend.Data_Transfer_Object;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class RegisterForm {

    private String username;
    private String password;
    private String email;
    private String numberPhone;
    private String role;
    //Customer
    private String customerName;
    private Integer age;
    //Admin
    private String fullName;



}

