package com.encore.outpick_backend.Store.service;

import com.encore.outpick_backend.Store.domain.StoreAddSalesDTO;
import com.encore.outpick_backend.Store.domain.StoreSalesDTO;
import com.encore.outpick_backend.Store.mapper.StoreSalesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StoreSalseService {

    @Autowired
    private StoreSalesMapper storeSalesMapper;

    //판매 내역 리스트
    public List<StoreSalesDTO> read_sales_list(int shopid){

        log.info("판매 내역 리스트 Service");

        return storeSalesMapper.read_sales_list(shopid);
    }//read_sales_list end

    //판매 내역 추가
    public void create_sales(StoreAddSalesDTO storeAddSalesDTO){
        log.info("판매 내역 추가 Service");

        storeSalesMapper.create_sales(storeAddSalesDTO);
    }//create_sales end

}
