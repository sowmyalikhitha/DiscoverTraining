package com.productdata2.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.productdata2.eo.ProductEo;

@FeignClient(name = "productdb-1", url = "http://localhost:8080")
public interface ProductFeignClient {

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductEo> getProduct(@PathVariable("id") Long id);
    
    @PostMapping("/products")
    public ResponseEntity<ProductEo> createProduct(@PathVariable("id") Long id);
}
