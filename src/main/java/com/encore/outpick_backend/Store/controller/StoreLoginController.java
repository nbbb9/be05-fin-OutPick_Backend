package com.encore.outpick_backend.Store.controller;

import com.encore.outpick_backend.Store.service.StoreLoginService;
import com.encore.outpick_backend.Store.domain.StoreLoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "매장로그인")
@RequestMapping("/store")
public class StoreLoginController {

    @Autowired
    private StoreLoginService storeLoginService;

    @Operation(summary = "매장 로그인", description = "매장 로그인입니다.")
    @PostMapping("/login")
    public ResponseEntity<?> login_store(@RequestBody StoreLoginDTO storeLoginDTO){
        log.info("매장 로그인 Controller\n", "매장명 : ", storeLoginDTO.getName(), "\n운영자 이메일 : ", storeLoginDTO.getEmail(), "\n운영자 : ", storeLoginDTO.getManager());

        Object response = storeLoginService.login_store(storeLoginDTO);

        if (response instanceof String) {
            return ResponseEntity.badRequest().body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }//login_store end

}
