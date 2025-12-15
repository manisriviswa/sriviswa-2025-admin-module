package com.sriviswa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

@Service
public class AdminService {

    @Autowired
    private VendorRepository vendorRepository;

    public Map<String, Object> getDashboardData(String organizationId) {
        Map<String, Object> dashboardData = new HashMap<>();
        List<?> allVendors = vendorRepository.findByOrganizationId(organizationId);
        List<?> pendingVendors = vendorRepository.findByOrganizationIdAndStatus(organizationId, "PENDING");
        List<?> approvedVendors = vendorRepository.findByOrganizationIdAndStatus(organizationId, "APPROVED");
        
        dashboardData.put("totalVendors", allVendors.size());
        dashboardData.put("pendingVendors", pendingVendors.size());
        dashboardData.put("approvedVendors", approvedVendors.size());
        return dashboardData;
    }

    public List<?> getVendorsByOrganization(String organizationId) {
        return vendorRepository.findByOrganizationId(organizationId);
    }

    public Object getVendorById(String id, String organizationId) {
        return vendorRepository.findByIdAndOrganizationId(id, organizationId);
    }

    public Object approveVendor(String id, String organizationId) {
        Object vendor = vendorRepository.findByIdAndOrganizationId(id, organizationId);
        if (vendor != null) {
            // Update vendor status to APPROVED
            Map<String, Object> result = new HashMap<>();
            result.put("status", "success");
            result.put("message", "Vendor approved");
            result.put("vendorId", id);
            result.put("approvedAt", LocalDateTime.now());
            return result;
        }
        return null;
    }

    public Object rejectVendor(String id, String organizationId, String reason) {
        Object vendor = vendorRepository.findByIdAndOrganizationId(id, organizationId);
        if (vendor != null) {
            Map<String, Object> result = new HashMap<>();
            result.put("status", "success");
            result.put("message", "Vendor rejected");
            result.put("vendorId", id);
            result.put("rejectionReason", reason);
            result.put("rejectedAt", LocalDateTime.now());
            return result;
        }
        return null;
    }
}
