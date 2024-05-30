package com.encore.outpick_backend.Analyze.service;

import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireVO;
import com.encore.outpick_backend.Analyze.mapper.AnalyzeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyzeService {
    @Autowired
    private AnalyzeMapper analyzeMapper;

    public List<AnalyzeEntireVO> get_analyze_entire(){
        return analyzeMapper.get_analyze_entire();
    }
}
