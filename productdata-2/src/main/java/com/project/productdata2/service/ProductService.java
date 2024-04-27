package com.project.productdata2.service;

import java.util.List;

import com.project.productdata2.eo.ProductEo;

public interface ProductService {
	ProductEo createProduct(ProductEo product);
    ProductEo getProduct(Long productId);
    List<ProductEo> getAllProducts();
}
