package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

@Data
public class AnalyzeSCResponseDTO {

    private int sales_quantity;//판매량
    private String first_classification;//1차 분류
    private String second_classification;//2차분류

}
