package com.encore.outpick_backend.Store.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class StoreSalesDTO {

    private int shop_sales_id;//매장판매 ID
    private int quantity;//판매량(수량)
    private Date date;//판매일
    private String product_name;//상품이름
    private String color;//색상
    private int size;//사이즈

}