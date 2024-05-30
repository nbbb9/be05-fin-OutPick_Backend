package com.encore.outpick_backend.Shop.controller;

import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Shop.domain.ShopDTO;
import com.encore.outpick_backend.Shop.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Tag(name = "매장")
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private LoginController lc;

    @Operation(summary = "로그인한 사원이 담당한 매장을 리스트로 가져오기", description = "매장 리스트")
    @GetMapping("/tolist")
    public ResponseEntity<List<ShopDTO>> get_shop_list(@RequestHeader("login_token") String token){

        log.info("debug : 로그인한 사원이 담당한 매장리스트 " , "token : ",token);

        LoginDTO user = lc.getTokenInfo(token);

        return new ResponseEntity<List<ShopDTO>>(shopService.get_shop_list(user), HttpStatus.OK);
    }//getShopList end

    @Operation(summary = "전체 매장 리스트 조회", description = "전체 매장 리스트")
    @GetMapping("/detail/tolist/all")
    public ResponseEntity<List<ShopDTO>> get_all_shop(){

        log.info("debug : 전체 매장 리스트로 조회 ");

        return new ResponseEntity<List<ShopDTO>>(shopService.get_all_shop(), HttpStatus.OK);
    }//getAllShop end

    @Operation(summary = "로그인한 사원이 담당한 매장의 상세정보 확인", description = "매장 상세정보 확인")
    @GetMapping("/detail/{shopid}")
    public ResponseEntity<ShopDTO> get_shop_detail(@RequestHeader("login_token") String token, @PathVariable("shopId") int shopId){

        log.info("debug : 로그인한 사원이 담당한 매장 상세정보 " , "token : " , token , " shopId : ", shopId);

        LoginDTO user = lc.getTokenInfo(token);

        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setShop_id(shopId);

        Map<LoginDTO, ShopDTO> paramMap = new HashMap<>();
        paramMap.put(user, shopDTO);

        return new ResponseEntity<ShopDTO>(shopService.get_shop_detail(paramMap), HttpStatus.OK);
    }//getShopDetail end

}