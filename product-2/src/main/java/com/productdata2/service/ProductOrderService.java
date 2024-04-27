package com.productdata2.service;

import org.springframework.http.ResponseEntity;
import com.productdata2.eo.ProductEo;

public interface ProductOrderService {
	   public ResponseEntity<ProductEo> retrieveProductUsingRestTemplate(Long id);
	   public ResponseEntity<ProductEo> retrieveProductUsingFeignClient(Long id);
}

