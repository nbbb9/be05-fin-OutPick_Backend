package com.encore.outpick_backend.Stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.outpick_backend.Stock.domain.StockDTO;
import com.encore.outpick_backend.Stock.mapper.StockMapper;

@Service
public class StockService {

    @Autowired
    private StockMapper stockMapper;

    // 재고 조회
    public List<StockDTO> read_stock(){
        System.out.println(">>> debug Stock Service read_stock");
        return stockMapper.read_stock();
    }
}
