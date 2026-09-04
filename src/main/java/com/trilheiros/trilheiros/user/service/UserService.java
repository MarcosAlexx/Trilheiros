package com.trilheiros.trilheiros.user.service;

import com.trilheiros.trilheiros.user.dto.UserRegisterDTO;
import com.trilheiros.trilheiros.user.dto.UserResponseDTO;
import com.trilheiros.trilheiros.user.entity.User;
import com.trilheiros.trilheiros.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    public UserResponseDTO registerUser(UserRegisterDTO userRegisterDTO) {
        User user = User.builder()
                .name(userRegisterDTO.name())
                .age(userRegisterDTO.age())
                .email(userRegisterDTO.email())
                .whatsapp(userRegisterDTO.whatsapp())
                .city(userRegisterDTO.city())
                .state(userRegisterDTO.state())
                .password(userRegisterDTO.password())
                .createdAt(java.time.LocalDateTime.now())
                .build();
        this.userRepository.save(user);
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getWhatsapp(), user.getAge(), user.getCity(), user.getState(), user.getCreatedAt());
    }


    public UserResponseDTO getUserByEmail(UserRegisterDTO userRegisterDTO) {
        User user = this.userRepository.findByEmail(userRegisterDTO.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getWhatsapp(), user.getAge(), user.getCity(), user.getState(), user.getCreatedAt());
    }



    public UserResponseDTO update(UserRegisterDTO userRegisterDTO) {

        User user = this.userRepository.findByEmail(userRegisterDTO.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userRegisterDTO.name());
        user.setAge(userRegisterDTO.age());
        user.setWhatsapp(userRegisterDTO.whatsapp());
        user.setCity(userRegisterDTO.city());
        user.setState(userRegisterDTO.state());
        user.setPassword(userRegisterDTO.password());
        user.setCreatedAt(java.time.LocalDateTime.now());

        this.userRepository.save(user);
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getWhatsapp(), user.getAge(), user.getCity(), user.getState(), user.getCreatedAt());
    }

    public String delete(UserRegisterDTO userRegisterDTO) {
        User user = this.userRepository.findByEmail(userRegisterDTO.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
        this.userRepository.delete(user);
        return System.out.printf("User %s deleted successfully", user.getEmail()).toString();
    }

    public UserResponseDTO getUserByEmail(UserRegisterDTO userRegisterDTO) {
        User user = this.userRepository.findByEmail(userRegisterDTO.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserResponseDTO.delete;
    }



}
