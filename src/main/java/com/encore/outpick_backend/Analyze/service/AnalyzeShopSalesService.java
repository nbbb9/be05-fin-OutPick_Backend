package com.encore.outpick_backend.Analyze.service;

import com.encore.outpick_backend.Analyze.domain.*;
import com.encore.outpick_backend.Analyze.mapper.AnalyzeMapper;
import com.encore.outpick_backend.Analyze.mapper.AnalyzeShopSalesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnalyzeShopSalesService {

    private final AnalyzeShopSalesMapper analyzeShopSalesMapper;

    public AnalyzeShopSalesResultDTO read_list(int year, int month){

        List<AnalyzeShopSalesDTO> lists = analyzeShopSalesMapper.read_list(year, month);

        AnalyzeShopSalesResultDTO result = new AnalyzeShopSalesResultDTO();

        for(AnalyzeShopSalesDTO list : lists){
            result.getQuantity().add(list.getQuantity());
            result.getShop_id().add(list.getShop_id());
            result.getShop_name().add(list.getShop_name());
            result.getWhole_money().add(list.getWhole_money());
        }

        return result;        
    }

    public AnalyzeSRResultDTO read_sr_list(AnalyzeSRRequestDTO analyzeSRRequestDTO) {

        List<AnalyzeSRResponseDTO> lists = analyzeShopSalesMapper.read_sr_list(analyzeSRRequestDTO);
        
        AnalyzeSRResultDTO result = new AnalyzeSRResultDTO();

        for(AnalyzeSRResponseDTO list : lists){
            result.getYear_list().add(list.getYear());
            result.getQuantity_list().add(list.getQuantity());
        }

        return result;

    }//read_sr_list end

}
