package com.encore.outpick_backend.Analyze.service;

import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireVO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeFCRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeFCResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeFCResultDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzePriceRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzePriceResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzePriceResultDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeProductRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeProductResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeProductResultDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeSCResultDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeSCRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeSCResponseDTO;
import com.encore.outpick_backend.Analyze.mapper.AnalyzeMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
            result.getWholeMoney().add(list.getWholeMoney());
        }

        return result;

    }

    public AnalyzeFCResultDTO read_fc_list(AnalyzeFCRequestDTO analyzeFCRequestDTO){
        log.info("read_fc_list Service");

        List<AnalyzeFCResponseDTO> lists = analyzeMapper.read_fc_list(analyzeFCRequestDTO);

        AnalyzeFCResultDTO result = new AnalyzeFCResultDTO();
        for(AnalyzeFCResponseDTO list : lists) {
            if(list.getSeason().equals("Spring")){
                result.getSpring_2c().add(Optional.ofNullable(list.getCategory())
                                                    .orElse(Optional.ofNullable(list.getFit())
                                                    .orElse(list.getColor())));
                result.getSpring_q().add(list.getQuantity());
            }else if(list.getSeason().equals("Summer")){
                result.getSummer_2c().add(Optional.ofNullable(list.getCategory())
                                                    .orElse(Optional.ofNullable(list.getFit())
                                                    .orElse(list.getColor())));
                result.getSummer_q().add(list.getQuantity());
            }else if(list.getSeason().equals("Fall")){
                result.getFall_2c().add(Optional.ofNullable(list.getCategory())
                                                    .orElse(Optional.ofNullable(list.getFit())
                                                    .orElse(list.getColor())));
                result.getFall_q().add(list.getQuantity());
            }else{
                result.getWinter_2c().add(Optional.ofNullable(list.getCategory())
                                                    .orElse(Optional.ofNullable(list.getFit())
                                                    .orElse(list.getColor())));
                result.getWinter_q().add(list.getQuantity());
            }
        }
        return result;
    }//read_fc_list end

    //read_sc_list start
    public AnalyzeSCResultDTO read_sc_list(AnalyzeSCRequestDTO analyzeSCRequestDTO) {
        List<AnalyzeSCResponseDTO> lists = analyzeMapper.read_sc_list(analyzeSCRequestDTO);
    
        AnalyzeSCResultDTO result = new AnalyzeSCResultDTO();
        
        for(AnalyzeSCResponseDTO list : lists) {
            if(list.getFit().equals("기본핏")) {
                result.getStandard_2c().add(list.getCategory() != null ? list.getCategory() : list.getSeason());
                result.getStandard_q().add(list.getQuantity());
            } else if(list.getFit().equals("루즈핏")) {
                result.getOver_2c().add(list.getCategory() != null ? list.getCategory() : list.getSeason());
                result.getOver_q().add(list.getQuantity());
            } else {
                result.getSlim_2c().add(list.getCategory() != null ? list.getCategory() : list.getSeason());
                result.getSlim_q().add(list.getQuantity());
            }
        }

        return result;

    }

    public AnalyzePriceResultDTO read_price_list(AnalyzePriceRequestDTO analyzePriceRequestDTO){
        
        List<AnalyzePriceResponseDTO> lists = analyzeMapper.read_price_list(analyzePriceRequestDTO);

        AnalyzePriceResultDTO result = new AnalyzePriceResultDTO();

        for (AnalyzePriceResponseDTO list : lists) {
            result.getPrice().add(list.getPrice());
            result.getQuantity().add(list.getQuantity());
        }

        return result;

    }

    // 매장별 상품들을 잘 팔린 순서대로 정렬
    public AnalyzeProductResultDTO read_product_list(AnalyzeProductRequestDTO analyzeProductRequestDTO) {
        
        List<AnalyzeProductResponseDTO> lists = analyzeMapper.read_product_list(analyzeProductRequestDTO);

        AnalyzeProductResultDTO result = new AnalyzeProductResultDTO();

        for (AnalyzeProductResponseDTO list : lists) {
            result.getProduct_name().add(list.getProduct_name());
            result.getQuantity().add(list.getQuantity());
        }

        return result;
    } 
}
