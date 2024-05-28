package com.encore.outpick_backend.Stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.outpick_backend.Stock.domain.StockDTO;
import com.encore.outpick_backend.Stock.service.StockService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Tag(name = "재고", description = "재고와 관련된 api 목록")
public class StockController {
    @Autowired
    private StockService stockService;

    // 재고 조회
    @GetMapping("/officestock")
    @Operation(summary = "재고 조회" , description = "재고 목록을 불러오는 api")
    public ResponseEntity<List<StockDTO>> read_stock() {
        System.out.println(">>>> debug Stock Controller GET: /officestock");
        List<StockDTO> result = stockService.read_stock();
        return new ResponseEntity<List<StockDTO>>(result,HttpStatus.OK);
    }
    
}
