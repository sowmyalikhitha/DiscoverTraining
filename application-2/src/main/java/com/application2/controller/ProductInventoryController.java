package com.application2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application2.entity.ProductInventoryEo;
import com.application2.service.ProductInventoryService;

@RestController
@RequestMapping("/products")
public class ProductInventoryController {
	
    @Autowired
    private ProductInventoryService productService;

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<ProductInventoryEo> retrieveProductUsingRestTemplate(@PathVariable("id") Long id) {
        return productService.retrieveProductUsingRestTemplate(id);
    }
}

