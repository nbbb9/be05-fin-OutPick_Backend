package com.encore.outpick_backend.Store.domain;

import lombok.Data;

@Data
public class StoreAddStockRequestDTO {

    private int shop_id;//매장ID
    private int product_id;//상품ID
    private int amount;//수량

}
