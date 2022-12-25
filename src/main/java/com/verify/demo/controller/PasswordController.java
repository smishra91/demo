package com.verify.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verify.demo.requests.Password;
import com.verify.demo.response.PasswordApiResponse;
import com.verify.demo.service.PasswordService;

@RestController
public class PasswordController {

    @Autowired
    PasswordService passwordService;

    @PostMapping("/api/password/verify")
    public PasswordApiResponse verifyPassword(@RequestBody Password password){
        
        String passPhrase = password.getPassword();
        
        return passwordService.isValidPassword(passPhrase);
        
    }
}
