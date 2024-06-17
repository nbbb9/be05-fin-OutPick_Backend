package com.encore.outpick_backend.Shop.mapper;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Shop.domain.ShopDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {
    List<ShopDTO> get_shop_list(LoginDTO user_info);//로그인한 사원이 관리하는 매장을 리스트로 확인

    List<ShopDTO> get_all_shop();//전체 매장 리스트로 조회

    ShopDTO get_shop_detail(@Param("employee_number") int employee_number,@Param("shop_id") int shop_id);//로그인한 사원이 관리하는 매장 정보를 확인

    ShopDTO get_shop_detail_admin(int shop_id);
}