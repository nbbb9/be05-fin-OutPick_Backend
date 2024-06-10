package com.encore.outpick_backend.Stock.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ShopStockDTO {
    private int shop_stock_id;
    private int shop_id;
    private String shop_name;
    private int product_id;
    private String product_name;
    private String gender;
    private String category_name;
    private String color;
    private String season;
    private String fit;
    private String first_cost;
    private int stock;
    private LocalDateTime stock_date;
    private int discount;
    private int size;
}
