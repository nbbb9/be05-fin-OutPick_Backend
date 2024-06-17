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
    public List<ShopDTO> get_shop_list(LoginDTO login_info){ return shopMapper.get_shop_list(login_info); }
    //전체 매장 리스트로 조회
    public List<ShopDTO> get_all_shop(){ return shopMapper.get_all_shop(); }
    //로그인한 사원이 관리하는 매장 정보를 단일 조회(상세조회)할 수 있다.
    public ShopDTO get_shop_detail(int employee_number, int shop_id){
        return shopMapper.get_shop_detail(employee_number, shop_id); 
    }
    //관리자로 로그인시 모든 매장 정보를 단일 조회(상세조회)할 수 있다.
    public ShopDTO get_shop_detail_admin(int shop_id){
        return shopMapper.get_shop_detail_admin(shop_id);
    }

}