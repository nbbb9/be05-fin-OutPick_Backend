package com.encore.outpick_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean   // security에 관한 filtering을 하는 객체
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();      // Security 제거
        http.headers().disable();   // Securiry 제거
        http.formLogin().disable(); // http의 form을 제거
        return http.build();
        // http응답에 대한 Security 생성
    }

    // 비밀번호를 encoding 하는 객체
    @Bean// 생성된 객체를 Spring Container에서 관리
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        // 실제로 구현하는 객체
    }
}
