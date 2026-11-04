package com.headoffice.stockms.repository;

import com.headoffice.stockms.branch.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> {
    boolean existsByBranchCode(String branchCode);
    boolean existsByName(String name);
    Optional<Branch> findByBranchCode(String branchCode);
    Optional<Branch> findByName(String name);
}
