package com.example.ecpaymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
@Autowired
AdminRepo adminRepo;

    public List<Admin> getAllAdminEntries() {
        return adminRepo.findAll();
    }

    public Admin getAdminEntryByKey(String key) {
        return adminRepo.findById(key).orElseThrow(() -> new RuntimeException("Key not found"));
    }

    public Admin saveAdminEntry(Admin admin) {
        return adminRepo.save(admin);
    }

    public void deleteAdminEntry(String key) {
        adminRepo.deleteById(key);
    }
}
