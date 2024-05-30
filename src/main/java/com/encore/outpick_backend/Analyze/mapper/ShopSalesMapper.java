package com.encore.outpick_backend.Analyze.mapper;

import com.encore.outpick_backend.Analyze.domain.ShopSalesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopSalesMapper {

    public List<ShopSalesDTO> read_list(int year, int month);
}
