package com.encore.outpick_backend.Store.service;

import com.encore.outpick_backend.Store.domain.StoreLoginDTO;
import com.encore.outpick_backend.Store.mapper.StoreLoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StoreLoginService {

    @Autowired
    private StoreLoginMapper storeLoginMapper;

    //매장 로그인
    public Object login_store(StoreLoginDTO storeLoginDTO){
        log.info("매장 로그인 Service");
        StoreLoginDTO result = storeLoginMapper.login_store(storeLoginDTO);
        if (result == null) {
            return "입력정보를 다시 확인해주세요";
        } else {
            return result;
        }//if-else end
    }//login_store end

}