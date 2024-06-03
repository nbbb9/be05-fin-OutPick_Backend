package com.encore.outpick_backend.Store.controller;

import com.encore.outpick_backend.Store.domain.StoreStockListDTO;
import com.encore.outpick_backend.Store.domain.StoreStockProductDTO;
import com.encore.outpick_backend.Store.service.StoreStockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@Tag(name = "매장재고 _ 매장프로그램", description = "매장재고와 관련된 API")
@RequestMapping("/store/stock")
public class StoreStockController {

    @Autowired
    private StoreStockService storeStockService;

    @Operation(summary = "재고 리스트")
    @GetMapping("/list/{shopid}")
    public ResponseEntity<List<StoreStockListDTO>> read_stock_list(@PathVariable("shopid") int shopid){
        log.info("재고 리스트 Controller. 매장 ID : " , shopid);

        return new ResponseEntity<>(storeStockService.read_stock_list(shopid), HttpStatus.OK);
    }//read_stock_list end

    @Operation(summary = "재고 상세조회")
    @GetMapping("/product/{stockid}")
    public ResponseEntity<StoreStockProductDTO> read_stock_product(@PathVariable("stockid") int stockid){
        log.info("재고 상세조회 Controller. 매장 ID : " , stockid);

        return new ResponseEntity<>(storeStockService.read_stock_product(stockid), HttpStatus.OK);
    }//read_stock_list end

}