package com.headoffice.stockms.user.service;

import com.headoffice.stockms.user.dto.CreateUserRequest;
import com.headoffice.stockms.user.dto.UserResponse;
import com.headoffice.stockms.user.entity.User;
import com.headoffice.stockms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stecurity.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository user repository;
    private final PasswordEncoder password encoder;

    @Transactional
    public UserResponse createUser(createUserRequest request){
        if (userRepository.exsistsByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username is already taken");

        }
        if (userRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email is alrady Registered" );
             }

        User user = User.buiilder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .isActive(true)
                .build();
                
        User savedUser = userRepository.save(user);

        return UserResponse.builder()
             .id(saveUser.getId())
             .username(saveUser.getUsername())
             .email(saveUser.getEmail())
             .role(saveUser.getRole())
             .isActive(saveUser.isActive())
             .createdAt(saveUser.getCreatedAt())
             .build();
    }
}