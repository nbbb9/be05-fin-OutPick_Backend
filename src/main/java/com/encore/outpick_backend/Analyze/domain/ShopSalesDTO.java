package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

@Data
public class ShopSalesDTO {
    private int quantity; // 매장별 월 총 판매량
    private int shop_id;
    private String shop_name;
}
