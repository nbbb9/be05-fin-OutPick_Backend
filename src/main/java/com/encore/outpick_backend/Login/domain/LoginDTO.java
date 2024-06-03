package com.encore.outpick_backend.Login.domain;

import lombok.Data;

@Data
public class LoginDTO {
    
    private int employee_number;
    private String password;
    private String role;

}