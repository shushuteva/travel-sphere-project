package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.LoginDto;
import com.travelsphere.travelsphere.exceptions.LoginException;

public interface LoginService {
    String logIntoAccount(LoginDto loginDto) throws LoginException;
    String logOutFromAccount(String key) throws LoginException;
}
