package com.headoffice.stockms.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class BranchResponse {
    private UUID id;
    private String branchCode;
    private String name;
    private String address;
    private String contactNumber;
    private String branchManager;
    private String areaManager;
    private boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;
}
