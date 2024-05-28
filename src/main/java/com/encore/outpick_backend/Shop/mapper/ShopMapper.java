package com.encore.outpick_backend.Shop.mapper;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Shop.domain.ShopDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {
    List<ShopDTO> showShops(LoginDTO user_info);//로그인한 사원이 관리하는 매장을 리스트로 확인

    List<ShopDTO> showAllShops();//전체 매장 리스트로 조회

    ShopDTO showShopDetail(Map<LoginDTO, ShopDTO> paramMap);//로그인한 사원이 관리하는 매장 정보를 확인
}