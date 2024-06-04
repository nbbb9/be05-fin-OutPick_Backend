package com.encore.outpick_backend.Analyze.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encore.outpick_backend.Analyze.domain.AERequestDTO;
import com.encore.outpick_backend.Analyze.domain.AEResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AEResultDTO;
import com.encore.outpick_backend.Analyze.mapper.AnalyzeEmployeeMapper;

@Service
public class AnalyzeEmployeeService {

    @Autowired
    AnalyzeEmployeeMapper analyzeEmployeeMapper;

    public AEResultDTO read_employee_analyze(AERequestDTO params) {
        List<AEResponseDTO> lists = analyzeEmployeeMapper.read_employee_analyze(params);
        
        AEResultDTO result = new AEResultDTO();
        for(AEResponseDTO list : lists) {
            result.getShop_list().add(list.getName());
            result.getSales_list().add(list.getQuantity());
        }
        
        return result;
    }
    
}
