package com.encore.outpick_backend.Stock.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StockDTO {
    private Integer stock_id;
    private Integer warehouse_id;
    private Integer product_id;
    private Integer stock;
    private LocalDateTime stock_date;
    private String warehouse_name;
    private String product_name;
    private Integer size;
    private String color;
    private Integer discount;
    private Integer quantity;
}
