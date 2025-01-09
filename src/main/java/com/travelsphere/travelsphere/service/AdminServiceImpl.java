package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.AdminException;
import com.travelsphere.travelsphere.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override

    public Admin createAdmin(Admin admin) throws AdminException {
        // TODO Auto-generated method stub

//		if(admin.getUserType().equals("ADMIN")) {  //we need to resolve enum issue

        Admin existingAdmin=adminRepo.findByEmail(admin.getEmail());

        if(existingAdmin!=null) throw new AdminException("Admin already Exists With this Email");



        Admin saveAdmin=adminRepo.save(admin);


        return saveAdmin;}
//		else {
//			throw new AdminException("Admin already Exists With this userType");
//		}
//	}



}
