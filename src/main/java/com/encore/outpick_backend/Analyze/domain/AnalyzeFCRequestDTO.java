package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

@Data
public class AnalyzeFCRequestDTO {

    private int year;//년도
    private int month;//월
    private int shop_id;//매장ID
    private String first_classification;//1차분류

}
