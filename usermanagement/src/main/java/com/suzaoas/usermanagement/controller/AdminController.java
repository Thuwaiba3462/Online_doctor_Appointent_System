package com.suzaoas.usermanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suzaoas.usermanagement.model.Admin;
import com.suzaoas.usermanagement.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Create a new admin
    @PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    // Get admin by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long admin_id) {
        Optional<Admin> admin = adminRepository.findById(admin_id);
        if (admin.isPresent()) {
            return ResponseEntity.ok(admin.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long admin_id, @RequestBody Admin adminDetails) {
        Optional<Admin> admin = adminRepository.findById(admin_id);
        if (admin.isPresent()) {
            Admin updatedAdmin = admin.get();
            updatedAdmin.setApassword(adminDetails.getApassword());
            // Set other properties to be updated
            // ...

            return ResponseEntity.ok(adminRepository.save(updatedAdmin));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long admin_id) {
        Optional<Admin> admin = adminRepository.findById(admin_id);
        if (admin.isPresent()) {
            adminRepository.delete(admin.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
