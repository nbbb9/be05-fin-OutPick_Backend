package com.encore.outpick_backend.Analyze.controller;

import com.encore.outpick_backend.Analyze.domain.*;
import com.encore.outpick_backend.Analyze.service.AnalyzeService;
import com.encore.outpick_backend.Analyze.service.AnalyzeShopSalesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@RestController
@RequestMapping("/analyze")
@Tag(name = "통계/분석", description = "통계/분석과 관련된 API")
public class AnalyzeController {
    @Autowired
    AnalyzeService analyzeService;

    @Autowired
    AnalyzeShopSalesService analyzeShopSalesService;

    // 회사의 월별 판매량 분석
    @Operation(summary = "회사의 월별 총 판매량" , description = "년도를 선택하여 회사의 월별 매출을 분석할 수 있다.")
    @GetMapping("/sales/{year}")
    public AnalyzeEntireVO get_analyze_entire(@PathVariable("year") int year){
        log.info("get_analyze_entire Controller");

        return analyzeService.get_analyze_entire(year);
    }//get_analyze_entire end

    // 매장별 월 판매량을 조회할 수 있다.
    @Operation(summary = "매장별 월 판매량", description = "년도와 월을 입력하여 매장별 월 판매량을 분석할 수 있다.")
    @GetMapping("/sales/{year}/{month}")
    public ResponseEntity<AnalyzeShopSalesResultDTO> read_anakyze_list(@PathVariable("year") int year, @PathVariable("month") int month){
        log.info("read_anakyze_list Controller");

        return new ResponseEntity<AnalyzeShopSalesResultDTO>(analyzeShopSalesService.read_list(year, month), HttpStatus.OK);
    }//read_list

    //특정 매장의 특정 월 특정 상품 / 특정 색깔 / 판매량을 조회할 수 있다.(좌측 하단의 그래프에서 특정 매장을 눌렀을 때)
    @Operation(summary = "(1차분류) 계절별 카테고리, 색상, 핏 통계",description = "연도를 선택한 후 계절별로 카테고리, 색상, 핏의 통계를 파이그래프로 볼 수 있다.")
    @PostMapping("/sales_analyze/fc")
    public ResponseEntity<AnalyzeFCResultDTO> read_fc_list(@RequestBody AnalyzeFCRequestDTO analyzeFCRequestDTO){
        log.info("read_fc_list Controller");

        return new ResponseEntity<AnalyzeFCResultDTO>(analyzeService.read_fc_list(analyzeFCRequestDTO), HttpStatus.OK);
    }//read_fc_list

    //특정 매장의 특정 월 특정 상품 / 특정 색깔 / 판매량을 조회할 수 있다.(좌측 하단의 그래프에서 특정 매장을 눌렀을 때)
    @Operation(summary = "(2차분류) 핏별 계절, 카테고리 통계", description = "연도를 선택한 후 핏별로 카테고리, 계절의 통계를 파이그래프로 볼 수 있다.")
    @PostMapping("/sales_analyze/sc")
    public ResponseEntity<AnalyzeSCResultDTO> read_sc_list(@RequestBody AnalyzeSCRequestDTO analyzeSCRequestDTO){
        log.info("read_sc_list Controller");

        return new ResponseEntity<AnalyzeSCResultDTO>(analyzeService.read_sc_list(analyzeSCRequestDTO), HttpStatus.OK);
    }//read_sc_list

    @PostMapping("/price_analyze")
    public ResponseEntity<AnalyzePriceResultDTO> read_price_list (@RequestBody AnalyzePriceRequestDTO analyzePriceRequestDTO) {
        log.info("read_price_list Controller");
        
        return new ResponseEntity<>(analyzeService.read_price_list(analyzePriceRequestDTO), HttpStatus.OK);
    }
    
    

}