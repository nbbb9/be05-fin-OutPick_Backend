package com.encore.outpick_backend.Store.service;

import com.encore.outpick_backend.Store.domain.StoreStockListDTO;
import com.encore.outpick_backend.Store.domain.StoreStockProductDTO;
import com.encore.outpick_backend.Store.mapper.StoreStockMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class StoreStockService {

    @Autowired
    private StoreStockMapper storeStockMapper;

    //재고 리스트
    public List<StoreStockListDTO> read_stock_list(int shopid){

        log.info("재고 리스트 Service");

        return storeStockMapper.read_stock_list(shopid);
    }//read_stock_list end

    //재고 상세조회
    public StoreStockProductDTO read_stock_product(int stockid){
        log.info("read_stock_product Controller");

        return storeStockMapper.read_stock_product(stockid);
    }//read_stock_product end

}
