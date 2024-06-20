package com.encore.outpick_backend.Analyze.mapper;

import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeFCRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeFCResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzePriceRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzePriceResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeProductRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeProductResponseDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeSCRequestDTO;
import com.encore.outpick_backend.Analyze.domain.AnalyzeSCResponseDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnalyzeMapper {
    List<AnalyzeEntireResponseDTO> get_analyze_entire(int year);
    public List<AnalyzeFCResponseDTO> read_fc_list(AnalyzeFCRequestDTO analyzeFCRequestDTO);
    public List<AnalyzeSCResponseDTO> read_sc_list(AnalyzeSCRequestDTO analyzeSCRequestDTO);
    public List<AnalyzePriceResponseDTO> read_price_list(AnalyzePriceRequestDTO analyzePriceRequestDTO);
    List<AnalyzeProductResponseDTO> read_product_list(AnalyzeProductRequestDTO analyzeProductRequestDTO);
}
