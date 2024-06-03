package com.encore.outpick_backend.Store.domain;

import lombok.Data;
import java.sql.Date;

@Data
public class StoreStockProductDTO {

    private int shop_stock_id;//매장 재고 아이디
    private Date date;//입고일
    private int discount;//할인율
    private int product_id;//상품ID
    private String season;//계절
    private String gender;//성별
    private String fit;//핏
    private int consumer_price;//소비자 판매가
    private int first_cost;//원가

}
