package com.example.api_messenger.controller;

import com.example.api_messenger.dto.UserRegistrationDTO;
import com.example.api_messenger.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerUser(@Valid @RequestBody UserRegistrationDTO dto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.addUser(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
