package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnalyzePriceResultDTO {

    private List<Integer> quantity;
    private List<Integer> price;

    public AnalyzePriceResultDTO() {
        this.quantity = new ArrayList<>();
        this.price = new ArrayList<>();
    }

}