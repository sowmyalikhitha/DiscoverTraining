package com.productdata.eo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductOrderEo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
    
    @NotNull
    @NotEmpty
    private String quantity;
    
    @NotNull
    @Positive
    private Double description;
}


