package com.wiremock.service;

import java.util.List;
import com.wiremock.entity.productEo;

public interface productService {
	String updateProduct(productEo product);
	String deleteProduct(Long productId);
	productEo getProduct(Long productId);
	List<productEo> getAllProducts();
	String createProduct(productEo product);
}

