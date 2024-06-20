package com.encore.outpick_backend.StockRequest.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StockRequestDTO {
    // 재고 요청서

    private int stock_request_id;
    private int shop_id;
    private int admin_id;
    private int product_id;
    private int amount; // 주문 수량
    private LocalDateTime request_date;
    private Approval approval;
    private AdminApproval admin_approval;

    private String shop_name; // 매장명
    private String product_name; // 상품명
    private int first_cost; // 상품 원가
    private String employee_name; // 담당자 이름
    private String admin_name; // 관리자(승인자) 이름
    private String manager; // 매장 담당자 이름
    
    private String feedback_content;//피드백 내용

}
