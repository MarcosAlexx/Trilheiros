package com.trilheiros.trilheiros.user.controller;


import com.trilheiros.trilheiros.user.dto.UserRegisterDTO;
import com.trilheiros.trilheiros.user.dto.UserResponseDTO;
import com.trilheiros.trilheiros.user.service.UserService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        UserResponseDTO userResponseDTO = userService.registerUser(userRegisterDTO);
        return ResponseEntity.ok(userResponseDTO);
    }


    @GetMapping("/get/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email) {
        UserResponseDTO userResponseDTO = userService.getUserByEmail(email);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable String email, @RequestBody UserRegisterDTO userRegisterDTO) {
        UserResponseDTO userResponseDTO = userService.update(email, userRegisterDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.delete(email);
        return ResponseEntity.noContent().build();
    }
}
