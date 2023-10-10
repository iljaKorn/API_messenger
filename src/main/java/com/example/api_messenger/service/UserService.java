package com.example.api_messenger.service;

import com.example.api_messenger.dto.UserRegistrationDTO;
import com.example.api_messenger.entity.User;
import com.example.api_messenger.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserRegistrationDTO dto) {
        User newUser = new User(dto.getId(), dto.getName(), dto.getSurname(),
                dto.getEmail(), dto.getLogin(), dto.getPassword());
        userRepository.save(newUser);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
