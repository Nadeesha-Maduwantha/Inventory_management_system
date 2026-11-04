package com.headoffice.stockms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBranchRequest {

    @NotBlank(message = "Branch code is required")
    @Size(min = 2, max = 20, message = "Branch code must be between 2 and 20 characters")
    private String branchCode;

    @NotBlank(message = "Branch name is required")
    @Size(min = 2, max = 100, message = "Branch name must be between 2 and 100 characters")
    private String name;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @Size(max = 20, message = "Contact number cannot exceed 20 characters")
    private String contactNumber;

    @Size(max = 100, message = "Branch manager name cannot exceed 100 characters")
    private String branchManager;

    @Size(max = 100, message = "Area manager name cannot exceed 100 characters")
    private String areaManager;
}
