package com.encore.outpick_backend.Product.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Integer product_id;
    private Integer category_id;
    private String name;
    private Integer consumer_price;
    private Integer size;
    private String gender;
    private String color;
    private String season;
    private String fit;
    private Integer first_cost;
}
