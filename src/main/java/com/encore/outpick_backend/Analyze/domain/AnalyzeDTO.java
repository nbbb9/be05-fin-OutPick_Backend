package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AnalyzeDTO {
    // from 매장 테이블
    private int shop_id;
    private int shop_name;

    // from 상품 테이블
    private int product_id;
    private String product_name;
//    private enumName gender;
//    private enumName season;
    private String fit;
    private int category_id;

    // from 카테고리 테이블
    private String category_name;

    // from 매장판매 테이블
    private int quantity;
    private Date date;
}
