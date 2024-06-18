package com.encore.outpick_backend.Analyze.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data

public class AnalyzeShopSalesResultDTO {
    
    private List<Integer> quantity;
    private List<Integer> shop_id;
    private List<String> shop_name;
    private List<Long> whole_money;

    public AnalyzeShopSalesResultDTO(){
        this.quantity = new ArrayList<>();
        this.shop_id = new ArrayList<>();
        this.shop_name = new ArrayList<>();
        this.whole_money = new ArrayList<>();
    }
}
