package com.encore.outpick_backend.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Login.mapper.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.HashMap;


@Slf4j
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder encoder;

    public Map<String, LoginDTO> login(LoginDTO login_info){

        Map<String,LoginDTO> map = new HashMap<String, LoginDTO>();

        LoginDTO user = loginMapper.login(login_info);

        if( user != null ){
            if(encoder.matches(login_info.getPassword(), user.getPassword())){
                // 로그인 성공
                map.put("성공", user);
            }else{
                // 로그인 실패
                map.put("실패", null);
            }
        }else{
            map.put("실패", null);
        }
        return map;
    }
    
}