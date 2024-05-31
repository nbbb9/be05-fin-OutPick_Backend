package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

@Data
public class AnalyzeSCRequestDTO {

    private int year;//년도
    private int month;//월
    private int shop_id;//매장ID
    private String first_classification;//1차분류
    private String first_choice;//1차분류 선택값
    private String second_classification;//2차분류
}
