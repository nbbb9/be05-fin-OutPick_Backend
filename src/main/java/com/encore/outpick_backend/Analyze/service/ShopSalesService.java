package com.encore.outpick_backend.Analyze.service;

import com.encore.outpick_backend.Analyze.domain.ShopSalesDTO;
import com.encore.outpick_backend.Analyze.mapper.ShopSalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopSalesService {

    private final ShopSalesMapper shopSalesMapper;

    public List<ShopSalesDTO> read_list(int year, int month){
        return shopSalesMapper.read_list(year, month);
    }
}
