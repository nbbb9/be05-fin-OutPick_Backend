package com.encore.outpick_backend.Analyze.service;

import com.encore.outpick_backend.Analyze.domain.*;
import com.encore.outpick_backend.Analyze.mapper.ShopSalesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopSalesService {

    private final ShopSalesMapper shopSalesMapper;

    public List<ShopSalesDTO> read_list(int year, int month){
        return shopSalesMapper.read_list(year, month);
    }//read_list end

    public List<AnalyzeFCResponseDTO> read_fc_list(AnalyzeFCRequestDTO analyzeFCRequestDTO){
        log.info("read_fc_list Service");

        return shopSalesMapper.read_fc_list(analyzeFCRequestDTO);
    }//read_fc_list end

    public List<AnalyzeSCResponseDTO> read_sc_list(AnalyzeSCRequestDTO analyzeSCRequestDTO){
        log.info("read_sc_list Service");

        return shopSalesMapper.read_sc_list(analyzeSCRequestDTO);
    }//read_sc_list end
}
