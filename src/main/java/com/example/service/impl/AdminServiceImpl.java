package com.example.service.impl;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        return optionalAdmin.orElse(null);
    }
   // @Override

   // public List<Admin> getAllAdmins() {
     //   return adminRepository.findAll();
    //}
   @Override
   public List<Admin> getAllAdmin() {

       return adminRepository.findAll();
   }

    @Override
    public Admin updateAdmin(Admin admin, Long adminId) {

        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        return optionalAdmin.map(existingAdmin -> {
            existingAdmin.setPassword(admin.getPassword());
            return adminRepository.save(existingAdmin);
        }).orElse(null);

    }

    @Override
    public void deleteAllAdminById(Long adminId) {

    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }



    //@Override
   // public void deleteAdmin(Long id) {
      //  adminRepository.deleteById(id);
    }

