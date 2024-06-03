package com.encore.outpick_backend.Store.mapper;

import com.encore.outpick_backend.Store.domain.StoreStockListDTO;
import com.encore.outpick_backend.Store.domain.StoreStockProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreStockMapper {

    //재고 리스트
    public List<StoreStockListDTO> read_stock_list(int shopid);
    //재고 상세조회
    public StoreStockProductDTO read_stock_product(int stockid);
}
