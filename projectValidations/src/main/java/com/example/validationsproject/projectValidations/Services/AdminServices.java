package com.example.validationsproject.projectValidations.Services;


import com.example.validationsproject.projectValidations.Entity.Admin;
import com.example.validationsproject.projectValidations.Model.AdminModel;
import com.example.validationsproject.projectValidations.Repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    public String adminCheck(int adminId, String adminPassword) {
        Optional<Admin> admin = adminRepository.findById(adminId);

        if (!admin.isPresent()) {
            return "Admin Not Available";
        }
        if (adminPassword == null) {
            return "Invalid Admin Password";
        }


        if (admin.get().getAdminPassword() == null) {
            return "Admin Password Not Set";
        }
        if ((admin.get().getAdminId()==(adminId)) && (admin.get().getAdminPassword().equals(adminPassword))) {
            return "Login Successful";
        } else
            return "Invalid Admin";
    }
    public String adminSave(int adminId,String adminPassword) {

        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setAdminPassword(adminPassword);

        // Save the Admin object using adminRepository
        adminRepository.save(admin);
        return "adminadded";
    }
    public List<AdminModel> getAllAdmins() {
        List<Admin> admins=adminRepository.findAll();
        List<AdminModel> AdminList=new ArrayList<>();
        admins.forEach(s->{
            AdminModel adminModel=new AdminModel();
            BeanUtils.copyProperties(s,adminModel);
            AdminList.add(adminModel);
            System.out.println("add to list");
        });
        return AdminList;
    }
//public Admin adminEntityToModelConverter{
//
//    }

    public String deleteAdmin(int adminId) {
        adminRepository.deleteById(adminId);
        return "deleted";
    }


    public AdminModel searchAdmin(int adminId) {
        Admin a=adminRepository.findById(adminId).orElse(null);
        AdminModel am=new AdminModel();
        BeanUtils.copyProperties(a,am);

        return am;
    }
}
