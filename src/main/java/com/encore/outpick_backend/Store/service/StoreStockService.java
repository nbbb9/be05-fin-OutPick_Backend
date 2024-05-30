package com.encore.outpick_backend.Store.service;

import com.encore.outpick_backend.Store.domain.StoreStockDTO;
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
    public List<StoreStockDTO> read_stock_list(StoreStockDTO storeStockDTO){

        log.info("재고 리스트 Service");

        return storeStockMapper.read_stock_list(storeStockDTO);
    }//read_stock_list end

}
