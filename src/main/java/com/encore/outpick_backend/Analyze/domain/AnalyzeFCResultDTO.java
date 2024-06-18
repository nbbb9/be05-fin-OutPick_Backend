package com.encore.outpick_backend.Analyze.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AnalyzeFCResultDTO {

    private List<String> spring_2c;
    private List<Long> spring_q;
    private List<String> summer_2c;
    private List<Long> summer_q;
    private List<String> fall_2c;
    private List<Long> fall_q;
    private List<String> winter_2c;
    private List<Long> winter_q;

    public AnalyzeFCResultDTO(){
        this.spring_2c = new ArrayList<>();
        this.spring_q = new ArrayList<>();
        this.summer_2c = new ArrayList<>();
        this.summer_q = new ArrayList<>();
        this.fall_2c = new ArrayList<>();
        this.fall_q = new ArrayList<>();
        this.winter_2c = new ArrayList<>();
        this.winter_q = new ArrayList<>();
    }

}
