package com.sriviswa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    private String id;
    
    @Column(nullable = false)
    private String organizationId;
    
    private String vendorName;
    private String panNumber;
    private String gstNumber;
    private String bankAccountNumber;
    private String bankName;
    private String ifscCode;
    private String contactPerson;
    private String contactEmail;
    private String contactPhone;
    
    @Column(length = 20)
    private String status = "PENDING";
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    private String rejectionReason;
    
    public Vendor() {}
    
    public Vendor(String id, String organizationId, String vendorName) {
        this.id = id;
        this.organizationId = organizationId;
        this.vendorName = vendorName;
    }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getOrganizationId() { return organizationId; }
    public void setOrganizationId(String organizationId) { this.organizationId = organizationId; }
    
    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
    
    public String getPanNumber() { return panNumber; }
    public void setPanNumber(String panNumber) { this.panNumber = panNumber; }
    
    public String getGstNumber() { return gstNumber; }
    public void setGstNumber(String gstNumber) { this.gstNumber = gstNumber; }
    
    public String getBankAccountNumber() { return bankAccountNumber; }
    public void setBankAccountNumber(String bankAccountNumber) { this.bankAccountNumber = bankAccountNumber; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
