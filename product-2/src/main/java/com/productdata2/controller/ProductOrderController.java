package com.productdata2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.productdata2.eo.ProductEo;
import com.productdata2.service.ProductOrderService;

@RestController
@RequestMapping("/products")
public class ProductOrderController {
	
    @Autowired
    private ProductOrderService productService;

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<ProductEo> retrieveProductUsingRestTemplate(@PathVariable("id") Long id) {
        return productService.retrieveProductUsingRestTemplate(id);
    }

    @GetMapping("/retrieve/feign/{id}")
    public ResponseEntity<ProductEo> retrieveProductUsingFeignClient(@PathVariable("id") Long id) {
        return productService.retrieveProductUsingFeignClient(id);
    }
}

