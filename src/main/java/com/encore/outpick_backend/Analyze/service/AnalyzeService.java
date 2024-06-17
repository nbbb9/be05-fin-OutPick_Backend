package com.encore.outpick_backend.Analyze.service;

import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireVO;
import com.encore.outpick_backend.Analyze.mapper.AnalyzeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyzeService {
    @Autowired
    private AnalyzeMapper analyzeMapper;

    public AnalyzeEntireVO get_analyze_entire(int year){

        List<AnalyzeEntireResponseDTO> lists = analyzeMapper.get_analyze_entire(year);

        AnalyzeEntireVO result = new AnalyzeEntireVO();

        for(AnalyzeEntireResponseDTO list : lists){
            result.getMonth().add(list.getMonth());
            result.getEntireQuantity().add(list.getEntireQuantity());
        }

        return result;

    }

}
