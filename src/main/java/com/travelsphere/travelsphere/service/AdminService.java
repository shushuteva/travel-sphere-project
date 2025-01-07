package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.AdminException;
import com.travelsphere.travelsphere.model.Admin;

public interface AdminService {

    public Admin createAdmin(Admin admin) throws AdminException;

}

