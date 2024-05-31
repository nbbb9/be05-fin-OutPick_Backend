package com.encore.outpick_backend.Analyze.controller;


import com.encore.outpick_backend.Analyze.domain.*;
import com.encore.outpick_backend.Analyze.service.ShopSalesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/analyze")
@Tag(name="매장별 월 판매량")
public class ShopSalesController {

    private final ShopSalesService shopSalesService;

    // 매장별 월 판매량을 조회할 수 있다.
    @Operation(summary = "매장별 월 판매량", description = "년도와 월을 입력하여 매장별 월 판매량을 조회할 수 있다.")
    @GetMapping("sales/{year}/{month}")
    public ResponseEntity<List<ShopSalesDTO>> read_anakyze_list(@PathVariable("year") int year, @PathVariable("month") int month){

        return new ResponseEntity<List<ShopSalesDTO>>(shopSalesService.read_list(year, month), HttpStatus.OK);
    }//read_list

    //특정 매장의 특정 월 특정 상품 / 특정 색깔 / 판매량을 조회할 수 있다.(좌측 하단의 그래프에서 특정 매장을 눌렀을 때)
    @Operation(summary = "특정매장 월 특정 상품 판매량 분석(1차분류)")
    @PostMapping("/sales_analyze/fc")
    public ResponseEntity<List<AnalyzeFCResponseDTO>> read_fc_list(@RequestBody AnalyzeFCRequestDTO analyzeFCRequestDTO){
         log.info("특정 년도, 월, 매장, 1차분류");

         return new ResponseEntity<>(shopSalesService.read_fc_list(analyzeFCRequestDTO), HttpStatus.OK);
    }//read_fc_list

    //특정 매장의 특정 월 특정 상품 / 특정 색깔 / 판매량을 조회할 수 있다.(좌측 하단의 그래프에서 특정 매장을 눌렀을 때)
    @Operation(summary = "특정매장 월 특정 상품 판매량 분석(2차분류)")
    @PostMapping("/sales_analyze/sc")
    public ResponseEntity<List<AnalyzeSCResponseDTO>> read_sc_list(@RequestBody AnalyzeSCRequestDTO analyzeSCRequestDTO){
        log.info("특정 년도, 월, 매장, 1차분류, 2차분류");

        return new ResponseEntity<>(shopSalesService.read_sc_list(analyzeSCRequestDTO), HttpStatus.OK);
    }//read_fc_list
}
