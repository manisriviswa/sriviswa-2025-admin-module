package com.sriviswa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
    
    List<Vendor> findByOrganizationId(String organizationId);
    
    List<Vendor> findByOrganizationIdAndStatus(String organizationId, String status);
    
    Optional<Vendor> findByIdAndOrganizationId(String id, String organizationId);
    
    List<Vendor> findByOrganizationIdAndStatusOrderByCreatedAtDesc(String organizationId, String status);
    
    List<Vendor> findByOrganizationIdOrderByCreatedAtDesc(String organizationId);
    
    long countByOrganizationIdAndStatus(String organizationId, String status);
    
    List<Vendor> findByOrganizationIdAndPanNumber(String organizationId, String panNumber);
    
    List<Vendor> findByOrganizationIdAndGstNumber(String organizationId, String gstNumber);
    
    List<Vendor> findByOrganizationIdAndBankAccountNumber(String organizationId, String bankAccountNumber);
}
