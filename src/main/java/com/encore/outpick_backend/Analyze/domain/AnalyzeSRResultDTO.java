package com.encore.outpick_backend.Analyze.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data

public class AnalyzeSRResultDTO {
    
    private List<Integer> year_list;
    private List<Integer> quantity_list;

    public AnalyzeSRResultDTO(){
        this.year_list = new ArrayList<>();
        this.quantity_list = new ArrayList<>();
    }

}
