package com.application1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.application1.entity.ProductEo;
import com.application1.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
        @Autowired
        private ProductService productService;


        @GetMapping("/{id}")
        public ProductEo getProductById(@PathVariable Long id) {
            return productService.getProductById(id);
        }

        @PostMapping
        public ProductEo createProduct(@RequestBody ProductEo product) {
            return productService.createProduct(product);
    }
}
