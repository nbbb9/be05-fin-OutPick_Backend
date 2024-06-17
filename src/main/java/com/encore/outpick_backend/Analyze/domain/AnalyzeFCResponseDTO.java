package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


@Data
public class AnalyzeFCResponseDTO {

    private List<Integer> sales_quantity;//판매량
    private List<String> first_classification;//1차 분류


    public AnalyzeFCResponseDTO(){
        this.sales_quantity = new ArrayList<>();
        this.first_classification = new ArrayList<>();
    }
}