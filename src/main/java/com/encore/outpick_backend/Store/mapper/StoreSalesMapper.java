package com.encore.outpick_backend.Store.mapper;

import com.encore.outpick_backend.Store.domain.StoreAddSalesDTO;
import com.encore.outpick_backend.Store.domain.StoreSalesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreSalesMapper {

    //판매 내역 리스트
    public List<StoreSalesDTO> read_sales_list(int shopid);

    //판매 내역 추가
    public void create_sales(StoreAddSalesDTO storeAddSalesDTO);
}
