package com.encore.outpick_backend.WareHouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.encore.outpick_backend.WareHouse.domain.WareHouseDTO;

@Mapper
public interface WareHouseMapper {
    // 창고 리스트 조회
    public List<WareHouseDTO> read_warehouse_list();

    // 창고 단일 조회
    public List<WareHouseDTO> read_warehouse(Integer warehouse_id);
}