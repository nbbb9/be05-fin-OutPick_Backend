package com.encore.outpick_backend.Stock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.encore.outpick_backend.Stock.domain.StockDTO;

@Mapper
public interface StockMapper {
    // 재고 조회
    public List<StockDTO> read_stock();
}
