package com.encore.outpick_backend.Store.domain;

import lombok.Data;

import java.util.Date;

@Data
public class StoreStockDTO {

    private int shop_stock_id;//매장 재고 ID
    private int shop_id;//매장 ID
    private int product_id;//상품ID
    private int stock;//재고량
    private Date stock_date;//입고일
    private int discount;//할인울

}
