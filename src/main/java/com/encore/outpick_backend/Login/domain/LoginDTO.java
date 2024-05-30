package com.encore.outpick_backend.Login.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class LoginDTO {
    
    private int employee_number;
    private String password;
    private String role;

}
