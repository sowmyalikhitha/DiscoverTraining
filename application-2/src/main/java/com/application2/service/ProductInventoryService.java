package com.application2.service;

import org.springframework.http.ResponseEntity;

import com.application2.entity.ProductInventoryEo;

public interface ProductInventoryService {
	    ResponseEntity<ProductInventoryEo> retrieveProductUsingRestTemplate(Long id);
}

