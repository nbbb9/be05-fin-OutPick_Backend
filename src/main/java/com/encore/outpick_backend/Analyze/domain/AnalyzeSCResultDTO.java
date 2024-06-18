package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnalyzeSCResultDTO {
    private List<String> standard_c;
    private List<Long> standard_q;
    private List<String> over_c;
    private List<Long> over_q;
    private List<String> slim_c;
    private List<Long> slim_q;

    public AnalyzeSCResultDTO() {
        this.standard_c = new ArrayList<>();
        this.standard_q = new ArrayList<>();
        this.over_c = new ArrayList<>();
        this.over_q = new ArrayList<>();
        this.slim_c = new ArrayList<>();
        this.slim_q = new ArrayList<>();
        
    }
}
