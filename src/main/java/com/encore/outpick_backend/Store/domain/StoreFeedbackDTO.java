package com.encore.outpick_backend.Store.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreFeedbackDTO {

    private String employee_name;//담당 사원 이름
    private String feedback_content;//피드백 내용
    private LocalDateTime creation_date;

}