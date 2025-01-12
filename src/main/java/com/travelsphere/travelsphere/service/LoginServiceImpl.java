package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.LoginDto;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.model.Admin;
import com.travelsphere.travelsphere.model.Customer;
import com.travelsphere.travelsphere.repository.AdminRepo;
import com.travelsphere.travelsphere.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String logIntoAccount(LoginDto loginDto) throws LoginException {
        if ("Admin".equalsIgnoreCase(loginDto.getUserType())) {
            Admin admin = adminRepo.findByEmail(loginDto.getUsername());
            if (admin == null || !admin.getPassword().equals(loginDto.getPassword())) {
                throw new LoginException("Invalid Admin credentials");
            }
            return "Admin login successful!";
        } else if ("Customer".equalsIgnoreCase(loginDto.getUserType())) {
            Customer customer = customerRepo.findByEmail(loginDto.getUsername());
            if (customer == null || !customer.getPassword().equals(loginDto.getPassword())) {
                throw new LoginException("Invalid Customer credentials");
            }
            return "Customer login successful!";
        }
        throw new LoginException("Invalid user type");
    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {
        if (key == null || key.isEmpty()) {
            throw new LoginException("Invalid session key");
        }
        return "Logout successful!";
    }
}
