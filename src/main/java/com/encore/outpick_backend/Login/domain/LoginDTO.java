package com.encore.outpick_backend.Login.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LoginDTO {
    
    private int employee_number;
    private String password;
    private String role;
    private String authorization;
    private String name;
    private int id;
    private Date expiration;
}