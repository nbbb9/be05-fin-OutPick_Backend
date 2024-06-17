package com.encore.outpick_backend.Stock.controller;

import java.util.List;
import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Stock.domain.ShopStockDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.encore.outpick_backend.Stock.domain.StockDTO;
import com.encore.outpick_backend.Stock.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Slf4j
@RestController
@Tag(name = "재고", description = "재고와 관련된 API")
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private LoginController loginController;

    // 재고 조회
    @GetMapping("/officestock")
    @Operation(summary = "창고 재고 조회" , description = "창고 재고 목록을 불러오는 api")
    public ResponseEntity<List<StockDTO>> read_stock() {
        log.info("read_stock Controller");
        List<StockDTO> result = stockService.read_stock();
        return new ResponseEntity<List<StockDTO>>(result,HttpStatus.OK);
    }

    @GetMapping("/shopstock/{shopid}")
    @Operation(summary = "매장별 재고 조회" , description = "사원이 담당하는 매장 재고 목록을 불러오는 api")
    public ResponseEntity<List<ShopStockDTO>> read_stock_shop(@RequestHeader("login_token") String token, @PathVariable("shopid") int shop_id){
        log.info(">>>> debug Stock Controller GET: /shopstock", shop_id);
        LoginDTO user = loginController.getTokenInfo(token);
        return new ResponseEntity<List<ShopStockDTO>>(stockService.read_stock_shop(user.getEmployee_number(), shop_id), HttpStatus.OK);
    }

    @GetMapping("/shopstock/detail/{shopid}")
    @Operation(summary = "매장별 재고 조회_매장 상세" , description = "매장 상세화면에서의 매장 재고목록을 불러오는 api")
    public ResponseEntity<List<ShopStockDTO>> read_stock_shop_detail(@PathVariable("shopid") int shop_id){
        log.info(">>>> debug Stock Controller GET: /shopstock", shop_id);
        return new ResponseEntity<List<ShopStockDTO>>(stockService.read_stock_shop_detail(shop_id), HttpStatus.OK);
    }

}