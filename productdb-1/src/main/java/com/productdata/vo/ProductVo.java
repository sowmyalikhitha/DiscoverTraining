package com.productdata.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductVo {
	@Id
    private Long id;
    private String name;
    private Double price;
} 

