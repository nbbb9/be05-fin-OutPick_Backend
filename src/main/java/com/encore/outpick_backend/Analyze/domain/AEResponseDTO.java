package com.encore.outpick_backend.Analyze.domain;

import lombok.Data;

@Data
public class AEResponseDTO {
    private String name;
    private int quantity;
    private int month;
    private int year;
}
