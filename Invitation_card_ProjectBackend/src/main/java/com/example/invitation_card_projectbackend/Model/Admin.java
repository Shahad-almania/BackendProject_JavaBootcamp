package com.example.invitation_card_projectbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Admin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer Id;
    private String fullName;
    private Integer userId;



}
