package com.encore.outpick_backend.ProductionRequest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductionWriteDTO {
     int product_id;
     int amount;

     @JsonIgnore
     int employee_id;

}
