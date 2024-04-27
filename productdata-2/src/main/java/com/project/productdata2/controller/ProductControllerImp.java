package com.project.productdata2.controller;

import com.project.productdata2.eo.ProductEo;
import com.project.productdata2.feign.FeignClient1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
public class ProductControllerImp implements ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductControllerImp.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignClient1 feignClient1;

    @GetMapping("/{id}")
    public ResponseEntity<ProductEo> getProduct(@PathVariable Long id) {
        logger.info("Fetching product with ID: {}", id);
        
        
        ProductEo productEoFeign = feignClient1.getProduct(id);
        if (productEoFeign != null) {
            logger.info("Product found with ID: {} using Feign Client", id);
            return ResponseEntity.ok(productEoFeign);
        }
        
        
        String url = "http://localhost:8080/products/" + id;
        ProductEo productEoRestTemplate = restTemplate.getForObject(url, ProductEo.class);
        if (productEoRestTemplate != null) {
            logger.info("Product found with ID: {} using RestTemplate", id);
            return ResponseEntity.ok(productEoRestTemplate);
        }

        logger.warn("Product not found with ID: {}", id);
        return ResponseEntity.notFound().build();
    }
}
