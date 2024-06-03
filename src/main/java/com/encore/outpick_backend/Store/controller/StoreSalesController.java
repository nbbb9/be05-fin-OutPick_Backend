package com.encore.outpick_backend.Store.controller;

import com.encore.outpick_backend.Store.domain.StoreAddSalesDTO;
import com.encore.outpick_backend.Store.domain.StoreSalesDTO;
import com.encore.outpick_backend.Store.service.StoreSalseService;
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
@Tag(name = "판매내역 _ 매장프로그램", description = "판매내역과 관련된 API")
@RequestMapping("/store/sales")
public class StoreSalesController {

    @Autowired
    private StoreSalseService storeSalseService;

    @Operation(summary = "판매 내역 리스트 조회")
    @GetMapping("/list/{shopid}")
    public ResponseEntity<List<StoreSalesDTO>> read_sales_list(@PathVariable("shopid") int shopid){
        log.info("판매 내역 리스트 Controller. 매장 ID : " , shopid);

        return new ResponseEntity<>(storeSalseService.read_sales_list(shopid), HttpStatus.OK);
    }//read_sales_list end

    @Operation(summary = "판매 내역 추가")
    @PostMapping("/add")
    public void create_sales (@RequestBody StoreAddSalesDTO storeAddSalesDTO){
        log.info("판매 내역 추가 Controller");

        storeSalseService.create_sales(storeAddSalesDTO);
    }//create_sales

}