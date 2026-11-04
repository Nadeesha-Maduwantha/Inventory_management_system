package com.headoffice.stockms.dto;

import com.headoffice.stockms.user.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private UUID id;
    private String username;
    private String email;
    private Role role;
    private boolean isActive;
    private Instant createdAt;
}
