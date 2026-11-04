package com.headoffice.stockms.service;

import com.headoffice.stockms.branch.entity.Branch;
import com.headoffice.stockms.dto.BranchResponse;
import com.headoffice.stockms.dto.CreateBranchRequest;
import com.headoffice.stockms.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    @Transactional
    public BranchResponse createBranch(CreateBranchRequest request) {
        if (branchRepository.existsByBranchCode(request.getBranchCode().trim())) {
            throw new IllegalArgumentException("Branch code '" + request.getBranchCode() + "' is already in use");
        }

        if (branchRepository.existsByName(request.getName().trim())) {
            throw new IllegalArgumentException("Branch name '" + request.getName() + "' is already in use");
        }

        Branch branch = Branch.builder()
                .branchCode(request.getBranchCode().trim().toUpperCase())
                .name(request.getName().trim())
                .address(request.getAddress())
                .contactNumber(request.getContactNumber())
                .branchManager(request.getBranchManager())
                .areaManager(request.getAreaManager())
                .isActive(true)
                .build();

        Branch savedBranch = branchRepository.save(branch);

        return mapToResponse(savedBranch);
    }

    @Transactional(readOnly = true)
    public List<BranchResponse> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public BranchResponse getBranchById(UUID id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Branch not found with ID: " + id));
        return mapToResponse(branch);
    }

    private BranchResponse mapToResponse(Branch branch) {
        return BranchResponse.builder()
                .id(branch.getId())
                .branchCode(branch.getBranchCode())
                .name(branch.getName())
                .address(branch.getAddress())
                .contactNumber(branch.getContactNumber())
                .branchManager(branch.getBranchManager())
                .areaManager(branch.getAreaManager())
                .isActive(branch.isActive())
                .createdAt(branch.getCreatedAt())
                .updatedAt(branch.getUpdatedAt())
                .build();
    }
}
