package com.headoffice.stockms.user.dto;

import com.headoffice.stockms.user.entity.Role;
import lombok.Data;
import lombok.Builder;
import java.util.UUID;
import java.time.instant;

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
