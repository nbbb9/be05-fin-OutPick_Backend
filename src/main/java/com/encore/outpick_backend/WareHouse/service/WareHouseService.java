package com.encore.outpick_backend.WareHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.outpick_backend.WareHouse.domain.WareHouseDTO;
import com.encore.outpick_backend.WareHouse.mapper.WareHouseMapper;

@Service
public class WareHouseService {
    
    @Autowired
    private WareHouseMapper wareHouseMapper;

    // 창고 리스트 조회
    public List<WareHouseDTO> read_warehouse_list() {
        System.out.println(">>> debug WareHouse service read_warehouse_list");
        return wareHouseMapper.read_warehouse_list();
    }

    // 창고 단일 조회
    public List<WareHouseDTO> read_warehouse(Integer warehouse_id) {
        System.out.println(">>> debug WareHouse service read_warehouse");
        return wareHouseMapper.read_warehouse(warehouse_id);
    }
}
