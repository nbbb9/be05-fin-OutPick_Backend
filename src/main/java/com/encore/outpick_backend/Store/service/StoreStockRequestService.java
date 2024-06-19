package com.encore.outpick_backend.Store.service;

import com.encore.outpick_backend.Product.domain.ProductDTO;
import com.encore.outpick_backend.Store.domain.StoreAddStockRequestDTO;
import com.encore.outpick_backend.Store.domain.StoreFeedbackDTO;
import com.encore.outpick_backend.Store.domain.StoreStockRequestDTO;
import com.encore.outpick_backend.Store.mapper.StoreStockRequestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StoreStockRequestService {

    @Autowired
    private StoreStockRequestMapper storeStockRequestMapper;

    public void create_stockRequest(StoreAddStockRequestDTO storeAddStockRequestDTO){
        log.info("재고요청서 작성 Service");
        storeStockRequestMapper.create_stockRequest(storeAddStockRequestDTO);
    }//create_stockRequest end

    public int find_employee_id(int shop_id){
        log.info("작성한 재고요청서의 담당 직원 Service");
        return storeStockRequestMapper.find_employee_id(shop_id);
    }//find_employee_id

    public List<ProductDTO> read_stockRequest_product(){
        log.info("read_stockRequest_product Service");
        return storeStockRequestMapper.read_stockRequest_product();
    }//read_stockRequest_product end

    public List<StoreStockRequestDTO> read_stockRequest_list(int shopid){
        log.info("read_stockRequest_list Service");
        return storeStockRequestMapper.read_stockRequest_list(shopid);
    }//read_stockRequest_list end

    public StoreFeedbackDTO read_feedback(int formid){
        log.info("read_feedback Service");
        return storeStockRequestMapper.read_feedback(formid);
    }//read_feedback end

}