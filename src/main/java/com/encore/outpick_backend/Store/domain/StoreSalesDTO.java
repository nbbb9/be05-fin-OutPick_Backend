package com.encore.outpick_backend.Store.domain;

import lombok.Data;

@Data
public class StoreSalesDTO {

    private int shop_sales_id;//매장판매 ID
    private int shop_id;//매장 ID
    private int product_id;//상품ID
    private int quantity;//판매량(수량)

}