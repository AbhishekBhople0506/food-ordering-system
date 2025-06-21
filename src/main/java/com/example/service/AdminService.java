package com.example.service;

import com.example.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin createAdmin(Admin admin);
    Admin getAdminById(Long adminId);
    Admin updateAdmin(Admin admin, Long adminId);

    void deleteAllAdminById(Long adminId);

    void deleteAdminById(Long adminId);

    // void deleteAllAdminById(Long adminId);
    void deleteAdmin(Long id);

    List<Admin> getAllAdmin();
}
