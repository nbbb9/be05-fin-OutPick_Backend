package com.encore.outpick_backend.Stock.mapper;

import java.util.List;

import com.encore.outpick_backend.Stock.domain.ShopStockDTO;
import org.apache.ibatis.annotations.Mapper;

import com.encore.outpick_backend.Stock.domain.StockDTO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper {
    // 재고 조회
    public List<StockDTO> read_stock();

    public List<ShopStockDTO> read_stock_shop(@Param("employee_number") int employee_number, @Param("shop_id") int shop_id);

    public List<ShopStockDTO> read_stock_shop_detail(@Param("shop_id") int shop_id);
}
