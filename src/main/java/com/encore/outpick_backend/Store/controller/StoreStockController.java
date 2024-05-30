package com.encore.outpick_backend.Store.controller;

import com.encore.outpick_backend.Store.domain.StoreStockDTO;
import com.encore.outpick_backend.Store.service.StoreStockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Tag(name = "매장 재고")
@RequestMapping("/store")
public class StoreStockController {

    @Autowired
    private StoreStockService storeStockService;

    @Operation(summary = "재고 리스트")
    @GetMapping("/stock/list")
    public ResponseEntity<List<StoreStockDTO>> read_stock_list(@RequestBody StoreStockDTO storeStockDTO){
        log.info("재고 리스트 Controller. 매장 ID : " , storeStockDTO.getShop_id());

        return new ResponseEntity<>(storeStockService.read_stock_list(storeStockDTO), HttpStatus.OK);
    }//read_stock_list end

}