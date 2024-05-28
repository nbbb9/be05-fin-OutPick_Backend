package com.encore.outpick_backend.Stock.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StockDTO {
    private Integer stock_id;
    private Integer warehouse_id;
    private Integer product_id;
    private Integer stock;
    private LocalDateTime stock_date;
}
