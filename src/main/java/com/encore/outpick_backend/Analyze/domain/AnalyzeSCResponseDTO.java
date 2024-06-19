package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

@Data
public class AnalyzeSCResponseDTO {

    private Long quantity;//판매량
    private String fit; // 핏
    private String season; // 계절
    private String category; // 카테고리

}
