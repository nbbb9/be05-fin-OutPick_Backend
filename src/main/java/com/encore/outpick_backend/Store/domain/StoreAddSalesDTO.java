package com.encore.outpick_backend.Store.domain;

import lombok.Data;


@Data
public class StoreAddSalesDTO {

    private int shop_id;//매장 ID
    private int product_id;//상품ID
    private int quantity;//수량

}
