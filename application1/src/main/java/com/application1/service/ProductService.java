package com.application1.service;

import com.application1.entity.ProductEo;

public interface ProductService {
	
	ProductEo getProductById(Long id);

	ProductEo createProduct(ProductEo product);
}
