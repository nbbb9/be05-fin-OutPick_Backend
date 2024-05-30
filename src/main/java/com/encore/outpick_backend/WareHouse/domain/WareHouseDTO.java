package com.encore.outpick_backend.WareHouse.domain;

import org.apache.ibatis.annotations.Mapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WareHouseDTO {
    private Integer warehouse_id;
    private String name;
    private String address;
    private String manager;
    private String contact;
}
