package com.productdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.productdata.service.ProductOrderService;
import com.productdata.vo.ProductVo;

@RestController
@RequestMapping("/products")
public class ProductOrderController {
	
    @Autowired
    private ProductOrderService productService;

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<ProductVo> retrieveProductUsingRestTemplate(@PathVariable Long id) {
        return productService.retrieveProductUsingRestTemplate(id);
    }

    @GetMapping("/retrieve/feign/{id}")
    public ResponseEntity<ProductVo> retrieveProductUsingFeignClient(@PathVariable Long id) {
        return productService.retrieveProductUsingFeignClient(id);
    }
}

