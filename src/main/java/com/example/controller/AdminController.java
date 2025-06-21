package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        Admin createadmin = adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createadmin);
        //return ResponseEntity.ok("Admin created successfully");

    }
    @GetMapping("/id")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id){
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
        //return ResponseEntity.ok("Admin retrieved successfully");
}

   @GetMapping("/GetAllAdmin")
   public ResponseEntity<List<Admin> > getAllAdmin(){
        List<Admin> admin = adminService.getAllAdmin();
        return ResponseEntity.ok(admin);
        //return ResponseEntity.ok("Admin retrieved successfully");
   }

   @PutMapping("/update/{Admin}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long AdminId, @RequestBody Admin admin){
        Admin updateAdmin = adminService.updateAdmin(admin, AdminId);
        return ResponseEntity.ok(updateAdmin);
        //return ResponseEntity.ok("Admin updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
        //return ResponseEntity.ok("Admin deleted successfully");
   }
}
