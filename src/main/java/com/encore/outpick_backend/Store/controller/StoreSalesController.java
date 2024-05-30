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
@Tag(name = "판매 내역")
@RequestMapping("/sales")
public class StoreSalesController {

    @Autowired
    private StoreSalseService storeSalseService;

    @Operation(summary = "판매 내역 리스트")
    @GetMapping("/list")
    public ResponseEntity<List<StoreSalesDTO>> read_sales_list(@RequestBody StoreSalesDTO storeSalesDTO){
        log.info("판매 내역 리스트 Controller. 매장 ID : " , storeSalesDTO.getShop_id());

        return new ResponseEntity<>(storeSalseService.read_sales_list(storeSalesDTO), HttpStatus.OK);
    }//read_sales_list end

    @Operation(summary = "판매 내역 추가")
    @PostMapping("/add")
    public void create_sales (@RequestBody StoreAddSalesDTO storeAddSalesDTO){
        log.info("판매 내역 추가 Controller");

        storeSalseService.create_sales(storeAddSalesDTO);
    }//create_sales

}