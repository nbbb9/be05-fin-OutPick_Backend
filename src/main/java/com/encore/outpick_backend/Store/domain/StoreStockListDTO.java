package com.encore.outpick_backend.Store.domain;

import lombok.Data;

@Data
public class StoreStockListDTO {

    private int product_id;//상품ID
    private String product_name;//상품 이름
    private String color;//색상
    private int size;//사이즈
    private int shop_stock_id;//매장 재고 ID
    private int stock;//재고량

}