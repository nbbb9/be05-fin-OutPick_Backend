package com.encore.outpick_backend.Login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Login.service.LoginService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping("/user")

public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login (@RequestBody LoginDTO loginInfo ) {
        
            log.info("login controller 접속");

        return loginService.login(loginInfo);
    }
    
    
}
