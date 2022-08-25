package com.example.invitation_card_projectbackend.Controller;

import com.example.invitation_card_projectbackend.Data_Transfer_Object.ApiResponse;
import com.example.invitation_card_projectbackend.Data_Transfer_Object.RegisterForm;

import com.example.invitation_card_projectbackend.Model.User;
import com.example.invitation_card_projectbackend.Repository.RepositoryCardOrder;
import com.example.invitation_card_projectbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    private RepositoryCardOrder repositoryCardOrder;

    @PostMapping("/register")  // User registration on the sit
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm) {
        userService.register(registerForm);
        return ResponseEntity.status(201).body(new ApiResponse("Add a new user account ..", 201));
    }

    @PostMapping("/login")  // User login to the site
    public ResponseEntity login() {
        return ResponseEntity.status(201).body(new ApiResponse("Welcom back User..", 201));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateuser(@RequestBody @Valid User user, @PathVariable Integer id){
        userService.updateuser(user,id);
        return ResponseEntity.status(201).body(new ApiResponse("Update user account..",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteuser(@PathVariable Integer id) {
        userService.deleteuser(id);
        return ResponseEntity.status(201).body(new ApiResponse("Delete user account..", 201));
    }

}


