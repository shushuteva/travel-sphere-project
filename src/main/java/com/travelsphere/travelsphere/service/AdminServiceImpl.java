package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.AdminDto;
import com.travelsphere.travelsphere.exceptions.AdminException;
import com.travelsphere.travelsphere.mapper.AdminMapper;
import com.travelsphere.travelsphere.model.Admin;
import com.travelsphere.travelsphere.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private AdminMapper adminMapper; 

    @Override
    public AdminDto createAdmin(AdminDto adminDto) throws AdminException {
        Admin admin = adminMapper.toEntity(adminDto);


        Admin existingAdmin = adminRepo.findByEmail(admin.getEmail());
        if (existingAdmin != null) {
            throw new AdminException("Admin already exists with this email");
        }

        Admin savedAdmin = adminRepo.save(admin);
        return adminMapper.toDto(savedAdmin);
    }
}
