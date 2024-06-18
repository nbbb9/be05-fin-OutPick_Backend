package com.encore.outpick_backend.Product.domain;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer product_id;
    private String name;
    private Integer price;
    private Integer size;
    private String gender;
    private String color;
    private String season;
    private String fit;
    private Integer first_cost;
    private String category;
    private Integer stock;
    private Integer quantity;
    private Integer shop_id;
}