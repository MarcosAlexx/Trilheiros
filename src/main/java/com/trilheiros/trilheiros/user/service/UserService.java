package com.trilheiros.trilheiros.user.service;

import com.trilheiros.trilheiros.user.dto.UserRegisterDTO;
import com.trilheiros.trilheiros.user.dto.UserResponseDTO;
import com.trilheiros.trilheiros.user.entity.User;
import com.trilheiros.trilheiros.user.exception.UserNotFoundException;
import com.trilheiros.trilheiros.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    public UserResponseDTO registerUser(UserRegisterDTO userRegisterDTO) {

        String hashedPassword = passwordEncoder.encode(userRegisterDTO.password());

        User user = User.builder()
                .name(userRegisterDTO.name())
                .age(userRegisterDTO.age())
                .email(userRegisterDTO.email())
                .whatsapp(userRegisterDTO.whatsapp())
                .city(userRegisterDTO.city())
                .state(userRegisterDTO.state())
                .password(hashedPassword)
                .createdAt(java.time.LocalDateTime.now())
                .build();
        this.userRepository.save(user);
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getWhatsapp(), user.getAge(), user.getCity(), user.getState(), user.getCreatedAt());
    }


    @Transactional
    public UserResponseDTO getUserByEmail(UserRegisterDTO userRegisterDTO) {
        User user = this.userRepository.findByEmail(userRegisterDTO.email())
                .orElseThrow(() -> new UserNotFoundException(userRegisterDTO.email()));

        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getWhatsapp(), user.getAge(), user.getCity(), user.getState(), user.getCreatedAt());
    }


    @Transactional
    public UserResponseDTO update(UserRegisterDTO userRegisterDTO) {
        User user = this.userRepository.findByEmail(userRegisterDTO.email())
                .orElseThrow(() -> new UserNotFoundException(userRegisterDTO.email()));

        String hashedPassword = passwordEncoder.encode(userRegisterDTO.password());

        user.setName(userRegisterDTO.name());
        user.setAge(userRegisterDTO.age());
        user.setWhatsapp(userRegisterDTO.whatsapp());
        user.setCity(userRegisterDTO.city());
        user.setState(userRegisterDTO.state());
        user.setPassword(hashedPassword);

        this.userRepository.save(user);
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getWhatsapp(), user.getAge(), user.getCity(), user.getState(), user.getCreatedAt());
    }


    @Transactional
    public void delete(UserRegisterDTO userRegisterDTO) {
        User user = userRepository.findByEmail(userRegisterDTO.email())
                .orElseThrow(() -> new UserNotFoundException(userRegisterDTO.email()));

        userRepository.delete(user);
    }

}
