package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

@Data
public class AnalyzeFCResponseDTO {

    private int sales_quantity;//판매량
    private String first_classification;//1차 분류

}