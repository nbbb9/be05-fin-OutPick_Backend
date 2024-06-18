package com.encore.outpick_backend.sse;

import lombok.Data;

@Data
public class ProductDiscountSSEDTO {
    private int shop_id;
    private int product_id;
}