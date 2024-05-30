package com.encore.outpick_backend.ProductionRequest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductionUpdateDTO {

    int production_request_id;
    int product_id;
    int amount;
    LocalDateTime request_date;

    @JsonIgnore
    int employee_number; // 생산요청서를 작성한 사원의 번호(사번)

}
