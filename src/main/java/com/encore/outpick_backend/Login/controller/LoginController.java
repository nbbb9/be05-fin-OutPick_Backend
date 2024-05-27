package com.encore.outpick_backend.Login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Login.service.LoginService;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
@RequestMapping("/user")

public class LoginController {

    @Autowired
    private LoginService loginService;

    // secretKey 생성
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @PostMapping("/login")
    public String login (@RequestBody LoginDTO loginInfo ) {
        
        log.info("login controller 접속");

        Map<String,LoginDTO> map = loginService.login(loginInfo);

        map.forEach((key,value) -> {
            log.info("key : " + key);
            log.info("value :" + value);
            log.info("value_empl :" + value.getEmployee_number() );
        } );

        String result;

        if(map.get("성공") != null){
            result = getToken(map.get("성공").getEmployee_number());
        }else{
            result = "로그인 실패하셨습니다!";
        }

        return result;
    }

    @GetMapping("/getInfo")
    public int getInfo (@RequestHeader("Authorization") String token ) {
        return getTokenInfo(token);
    }
    

    public String getToken(int employee_number){

        log.info("secretkey : " + Encoders.BASE64.encode(secretKey.getEncoded()));

        String token = Jwts.builder()
                            .claim("employee_number", employee_number)
                            .expiration(new Date(System.currentTimeMillis() + 1000*60*12))  // 제한기간 설정
                            .issuedAt(new Date())   // token 발급날짜
                            .signWith(secretKey)
                            .compact();

        return token;
    }

    public int getTokenInfo (String token){

        int num = Jwts.parser()
                        .verifyWith(secretKey)
                        .build()
                        .parseSignedClaims(token)
                        .getBody()
                        .get("employee_number", Integer.class);

        log.info("getInfo : " + num );

        return num;
    }
    
    
}
