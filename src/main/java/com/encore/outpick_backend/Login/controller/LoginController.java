package com.encore.outpick_backend.Login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Login.service.LoginService;
import io.jsonwebtoken.security.Keys;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@RestController
@Tag(name = "로그인", description = "로그인과 관련된 API")
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // secretKey 생성
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Operation(summary = "로그인", description = "로그인입니다.")
    @PostMapping("/login")
    public String login (@RequestBody LoginDTO loginInfo ) {
        
        log.info("login controller 접속");

        Map<String,LoginDTO> map = loginService.login(loginInfo);

        String result;

        if(map.containsKey("성공")){
            if (map.get("성공").getAuthorization().equals("A")) {
                map.get("성공").setRole("관리자");
            }else{
                map.get("성공").setRole("사원");
            }
            result = getToken(map.get("성공"));
        }else{
            result = "로그인 실패하셨습니다!";
        }

        return result;
    }   // login end

    @Operation(summary = "token값", description = "token에서 값 얻어오기")
    @GetMapping("/getInfo")
    public LoginDTO getInfo (@RequestHeader("login_token") String token) {
        return getTokenInfo(token);
    }   // getInfo end
    

    public String getToken(LoginDTO login_info){

        log.info("secretkey : " + Encoders.BASE64.encode(secretKey.getEncoded()));

        String token = Jwts.builder()
                            .claim("employee_number", login_info.getEmployee_number())
                            .claim("role", login_info.getRole())
                            .claim("name", login_info.getName())
                            .claim("id", login_info.getId())
                            .expiration(new Date(System.currentTimeMillis() + 1000*60*60))  // 제한기간 설정
                            .issuedAt(new Date())   // token 발급날짜
                            .signWith(secretKey)
                            .compact(); 

        return token;
    }   // getToken end

    public LoginDTO getTokenInfo (String token){

        Claims claims = Jwts.parser()
                        .verifyWith(secretKey)
                        .build()
                        .parseSignedClaims(token)
                        .getBody();

        int employee_number = claims.get("employee_number", Integer.class);
        String role = claims.get("role", String.class);
        String name = claims.get("name", String.class);
        int id = claims.get("id", Integer.class);                

        log.info("getInfo : " + employee_number );
        log.info("getInfo : " + role);
        log.info("getInfo : " + name);

        LoginDTO result = new LoginDTO();

        result.setEmployee_number(employee_number);
        result.setRole(role);
        result.setName(name);
        result.setId(id);
        result.setExpiration(claims.getExpiration());
        return result;
    }   // getToken end

}
