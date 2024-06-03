package com.encore.outpick_backend.WareHouse.controller;

import org.springframework.web.bind.annotation.RestController;

import com.encore.outpick_backend.WareHouse.domain.WareHouseDTO;
import com.encore.outpick_backend.WareHouse.service.WareHouseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Tag(name = "창고", description = "창고와 관련된 api 목록")
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;

    // 창고 리스트 조회
    @GetMapping("/warehouse")
    @Operation(summary = "창고 리스트" , description = "창고 목록을 불러오는 api")
    public ResponseEntity<List<WareHouseDTO>> read_warehouse_list() {
        System.out.println(">>>> debug WareHouse Controller GET: /warehouse");
        List<WareHouseDTO> result = wareHouseService.read_warehouse_list();
        return new ResponseEntity<List<WareHouseDTO>>(result,HttpStatus.OK);
    }
    
    // 창고 단일 조회
    @GetMapping("/warehouse/{warehouse_id}")
    @Operation(summary = "창고 단일 목록" , description = "창고 단일목록을 불러오는 api")
    public ResponseEntity<List<WareHouseDTO>> read_warehouse(@PathVariable Integer warehouse_id) {
        System.out.println(">>>> debug WareHouse Controller GET: /warehouse/{warehouse_id}");
        List<WareHouseDTO> result = wareHouseService.read_warehouse(warehouse_id);
        return new ResponseEntity<List<WareHouseDTO>>(result,HttpStatus.OK);
    }
    
}
