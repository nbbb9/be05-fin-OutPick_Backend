package com.encore.outpick_backend.Stock.service;

import java.util.List;

import com.encore.outpick_backend.Stock.domain.ShopStockDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.outpick_backend.Stock.domain.StockDTO;
import com.encore.outpick_backend.Stock.mapper.StockMapper;

@Slf4j
@Service
public class StockService {

    @Autowired
    private StockMapper stockMapper;

    // 재고 조회
    public List<StockDTO> read_stock(){
        System.out.println(">>> debug Stock Service read_stock");
        return stockMapper.read_stock();
    }

    public List<ShopStockDTO> read_stock_shop(int employee_number, int shop_id){
        log.info(">>> debug Stock Service read_stock_shop");
        return stockMapper.read_stock_shop(employee_number, shop_id);
    }

    public List<ShopStockDTO> read_stock_shop_detail(int shop_id){
        log.info(">>> debug Stock Service read_stock_shop");
        return stockMapper.read_stock_shop_detail(shop_id);
    }
}
