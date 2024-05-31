package com.encore.outpick_backend.Analyze.mapper;

import com.encore.outpick_backend.Analyze.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopSalesMapper {

    public List<ShopSalesDTO> read_list(int year, int month);

    public List<AnalyzeFCResponseDTO> read_fc_list(AnalyzeFCRequestDTO analyzeFCRequestDTO);

    public List<AnalyzeSCResponseDTO> read_sc_list(AnalyzeSCRequestDTO analyzeSCRequestDTO);
}
