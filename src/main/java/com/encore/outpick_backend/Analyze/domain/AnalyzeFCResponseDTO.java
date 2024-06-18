package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


@Data
public class AnalyzeFCResponseDTO {

    private String season;
    private String fit;
    private String category;
    private String color;
    private Long quantity; 

}