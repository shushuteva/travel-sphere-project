package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.model.LoginDto;

public interface LoginService {

    public String logIntoAccount(LoginDto dto)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;

}
