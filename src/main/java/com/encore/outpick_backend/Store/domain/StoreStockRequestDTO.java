package com.encore.outpick_backend.Store.domain;

import lombok.Data;
import java.sql.Date;

@Data
public class StoreStockRequestDTO {

    private int stock_request_id;//요청서ID
    private String shop_name;//지점명
    private Date request_date;//날짜
    private String employee_name;//담당자
    private String approval;//결재상태
    private int product_id;//상품ID
    private String product_name;//상품명
    private int amount;//주문수량
    private int shop_id; //매장 번호

}
