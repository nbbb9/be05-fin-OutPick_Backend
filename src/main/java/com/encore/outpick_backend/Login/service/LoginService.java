package com.encore.outpick_backend.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Login.mapper.LoginMapper;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder encoder;

    public String login(LoginDTO login_info){

        LoginDTO user = loginMapper.login(login_info);

        if( user != null ){
            
            if(encoder.matches(login_info.getPassword(), user.getPassword())){
                // 로그인 성공
                return "로그인 성공!";
            }else{
                // 로그인 실패
                return "로그인 실패!";
            }
            
        }else{
            return "해당하는 아이디가 없습니다.";
        }
        
    }

    
}
