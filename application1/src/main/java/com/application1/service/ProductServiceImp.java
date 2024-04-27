package com.application1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application1.dao.ProductDao;
import com.application1.entity.ProductEo;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductDao productRepository;
    
    @Override
    public ProductEo createProduct(ProductEo product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEo getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}