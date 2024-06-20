package com.encore.outpick_backend.StockRequest.domain;

import lombok.Data;

@Data
public class FeedbackDTO {
    private int stock_request_id;
    private String feedback_content;
}
