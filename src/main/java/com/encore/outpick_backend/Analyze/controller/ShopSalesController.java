package com.encore.outpick_backend.Analyze.controller;


import com.encore.outpick_backend.Analyze.domain.ShopSalesDTO;
import com.encore.outpick_backend.Analyze.service.ShopSalesService;
import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.StockRequest.domain.StockRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class ShopSalesController {

    private final ShopSalesService shopSalesService;
    private final LoginController loginController;


    // 매장별 월 판매량을 조회할 수 있다.
    @GetMapping("/{year}/{month}")
    public ResponseEntity<List<ShopSalesDTO>> read_list(@PathVariable("year") int year, @PathVariable("month") int month,
                                                        @RequestHeader("login_token") String token){

        return new ResponseEntity<List<ShopSalesDTO>>(shopSalesService.read_list(year, month), HttpStatus.OK);

    }
}
