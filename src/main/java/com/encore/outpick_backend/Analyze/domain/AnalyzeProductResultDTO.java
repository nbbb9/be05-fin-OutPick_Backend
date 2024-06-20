package com.encore.outpick_backend.Analyze.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AnalyzeProductResultDTO {

    private List<String> product_name;
    private List<Long> quantity;

    public AnalyzeProductResultDTO() {
        this.product_name = new ArrayList<>();
        this.quantity = new ArrayList<>();
    }
}
