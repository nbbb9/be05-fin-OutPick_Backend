package com.encore.outpick_backend.Store.domain;

import lombok.Data;

@Data
public class StoreFeedbackDTO {

    private String employee_name;//관리자 이름
    private int feedback_content;//피드백 내용
    private int month;//월
    private String first_classification;//1차분류
    private String second_classification;//2차분류

}