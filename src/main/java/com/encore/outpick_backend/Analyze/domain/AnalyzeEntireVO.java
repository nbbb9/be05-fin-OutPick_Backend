package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnalyzeEntireVO {
    private List<Integer> month;
    private List<Integer> entireQuantity;

    public AnalyzeEntireVO(){
        this.month = new ArrayList<>();
        this.entireQuantity = new ArrayList<>();
    }
}
