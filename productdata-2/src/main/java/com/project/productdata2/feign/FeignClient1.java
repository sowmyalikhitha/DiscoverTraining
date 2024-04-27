package com.project.productdata2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.productdata2.eo.ProductEo;

@FeignClient(name = "productdata-1", url ="http://localhost:8080")
public interface FeignClient1 {

	@GetMapping("/products/{id}")
    ProductEo getProduct(@PathVariable("id") Long id);
}

