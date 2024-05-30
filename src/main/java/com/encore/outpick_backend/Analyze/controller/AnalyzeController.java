package com.encore.outpick_backend.Analyze.controller;

import com.encore.outpick_backend.Analyze.domain.AnalyzeDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireVO;
import com.encore.outpick_backend.Analyze.service.AnalyzeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "통계/분석", description = "통계/분석과 관련된 api 목록")
@RestController
@RequestMapping("/sales")
public class AnalyzeController {
    @Autowired
    private AnalyzeService analyzeService;

    // 회사의 월별 판매량 분석
    @Operation(summary = "회사의 월별 총 판매량" , description = "회사의 전체매출을 불러오는 api")
    @GetMapping
    public List<AnalyzeEntireVO> get_analyze_entire(){

        return analyzeService.get_analyze_entire();
    }

//    @GetMapping("/{month}")


}
