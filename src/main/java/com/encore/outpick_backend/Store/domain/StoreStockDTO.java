package com.encore.outpick_backend.Store.domain;

import lombok.Data;

import java.util.Date;

@Data
public class StoreStockDTO {

    private int product_id;//상품ID
    private String product_name;//상품 이름
    private int stock;//재고량
    private String category;//카테고리

}
