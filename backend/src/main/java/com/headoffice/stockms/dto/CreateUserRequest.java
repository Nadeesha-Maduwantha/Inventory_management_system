package com.headoffice.stockms.user.entity;

import com.headoffice.stockms.user.entity.Role;
import jakarta.validationconstraints.*;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank(message = "Username is  required")
    @Size(min = 3, max =20, message = " username must be between 3 and 50 characters")
    private String username;
    
    @NotBlank(message = "Email is  required")
    @Email(message = "Email must be valid" )
    private String email;

    @NotBlank(message = "password is required")
    @Size(min =6, message = "password must be at least 6 characters")
    private String password;

    @NotNull(message =" Role is required")
    private Role role;
}
