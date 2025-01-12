package com.travelsphere.travelsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.dto.LoginDto;
import com.travelsphere.travelsphere.service.LoginService;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto) throws LoginException {
        String result = loginService.logIntoAccount(loginDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> userLogout(@RequestParam(required = false) String key) throws LoginException {
        String result = loginService.logOutFromAccount(key);
        return ResponseEntity.ok(result);
    }
}
