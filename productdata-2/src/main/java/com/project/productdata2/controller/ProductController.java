package com.project.productdata2.controller;

import com.project.productdata2.eo.ProductEo;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ProductController {
    ResponseEntity<ProductEo> getProduct(Long productId);
}