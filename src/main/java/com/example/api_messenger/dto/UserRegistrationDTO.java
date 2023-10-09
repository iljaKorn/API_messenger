package com.example.api_messenger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
}
