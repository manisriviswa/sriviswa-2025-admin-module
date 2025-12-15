package com.sriviswa.controller;

import com.sriviswa.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboard(Authentication authentication) {
        String organizationId = authentication.getName();
        Map<String, Object> dashboardData = adminService.getDashboardData(organizationId);
        return ResponseEntity.ok(dashboardData);
    }

    @GetMapping("/vendors")
    public ResponseEntity<?> getVendors(Authentication authentication) {
        String organizationId = authentication.getName();
        List<?> vendors = adminService.getVendorsByOrganization(organizationId);
        return ResponseEntity.ok(vendors);
    }

    @GetMapping("/vendors/{id}")
    public ResponseEntity<?> getVendorById(@PathVariable String id, Authentication authentication) {
        String organizationId = authentication.getName();
        Object vendor = adminService.getVendorById(id, organizationId);
        return ResponseEntity.ok(vendor);
    }

    @PutMapping("/vendors/{id}/approve")
    public ResponseEntity<?> approveVendor(@PathVariable String id, Authentication authentication) {
        String organizationId = authentication.getName();
        Object result = adminService.approveVendor(id, organizationId);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/vendors/{id}/reject")
    public ResponseEntity<?> rejectVendor(@PathVariable String id, @RequestBody Map<String, String> request, Authentication authentication) {
        String organizationId = authentication.getName();
        String reason = request.get("reason");
        Object result = adminService.rejectVendor(id, organizationId, reason);
        return ResponseEntity.ok(result);
    }
}
