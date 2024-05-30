package com.encore.outpick_backend.Store.mapper;

import com.encore.outpick_backend.Store.domain.StoreLoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreLoginMapper {

    public StoreLoginDTO login_store(StoreLoginDTO storeLoginDTO);//매장 로그인

}