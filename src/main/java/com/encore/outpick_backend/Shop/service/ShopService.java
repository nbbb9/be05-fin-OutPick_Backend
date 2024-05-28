package com.encore.outpick_backend.Shop.service;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Shop.domain.ShopDTO;
import com.encore.outpick_backend.Shop.mapper.ShopMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ShopService {

    @Autowired
    private ShopMapper shopMapper;

    //로그인한 사원이 관리하는 매장을 리스트로 확인
    public List<ShopDTO> getShops(LoginDTO login_info){ return shopMapper.showShops(login_info); }
    //전체 매장 리스트로 조회
    public List<ShopDTO> getAllShops(){ return shopMapper.showAllShops(); }
    //로그인한 사원이 관리하는 매장 정보를 단일 조회(상세조회)할 수 있다.
    public ShopDTO getDetail(Map<LoginDTO, ShopDTO> paramMap){ return shopMapper.showShopDetail(paramMap); }
}