package com.encore.outpick_backend.Store.mapper;

import com.encore.outpick_backend.Store.domain.StoreStockDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreStockMapper {

    //재고 리스트
    public List<StoreStockDTO> read_stock_list(StoreStockDTO storeStockDTO);

}
