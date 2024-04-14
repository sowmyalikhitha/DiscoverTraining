package com.productdata.service;

import org.springframework.http.ResponseEntity;

import com.productdata.eo.ProductEo;
import com.productdata.vo.ProductVo;

public interface ProductOrderService {
	    ResponseEntity<ProductVo> retrieveProductUsingRestTemplate(Long id);
	    ResponseEntity<ProductVo> retrieveProductUsingFeignClient(Long id);
}

