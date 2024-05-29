package com.encore.outpick_backend.Analyze.controller;

import com.encore.outpick_backend.Analyze.domain.AnalyzeDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireVO;
import com.encore.outpick_backend.Analyze.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class AnalyzeController {
    @Autowired
    private AnalyzeService analyzeService;

    // 회사의 월별 판매량 분석
    @GetMapping
    public List<AnalyzeEntireVO> get_analyze_entire(){

        return analyzeService.get_analyze_entire();
    }

//    @GetMapping("/{month}")


}
