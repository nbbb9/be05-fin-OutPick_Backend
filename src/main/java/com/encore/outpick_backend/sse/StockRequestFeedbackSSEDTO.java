package com.encore.outpick_backend.sse;

import lombok.Data;

@Data
public class StockRequestFeedbackSSEDTO {

    private int shop_id;
    private int stock_request_id;


}
