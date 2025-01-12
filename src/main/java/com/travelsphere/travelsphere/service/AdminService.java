package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.AdminDto;
import com.travelsphere.travelsphere.exceptions.AdminException;

public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto) throws AdminException;
}
