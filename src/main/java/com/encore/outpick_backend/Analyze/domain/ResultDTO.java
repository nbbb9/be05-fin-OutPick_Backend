package com.encore.outpick_backend.Analyze.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ResultDTO {
    private List<String> shop_list;
    private List<Integer> sales_list;

    public ResultDTO () {
        this.shop_list = new ArrayList<>();
        this.sales_list = new ArrayList<>();
    }

}
