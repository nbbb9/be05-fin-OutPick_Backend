package com.encore.outpick_backend.ProductionRequest.domain;

import lombok.Data;
import java.time.LocalDateTime;

// 생산요청서
@Data
public class ProductionRequestDTO {
    int production_request_id;
    int employee_id;
    int admin_id;
    int product_id;
    int amount;
    LocalDateTime request_date;
    String approval;
    String employee_name; // 생산요청서를 작성한 담당사원의 이름.
    String product_name; // 상품명
    int product_first_cost; // 상품 원가

}
