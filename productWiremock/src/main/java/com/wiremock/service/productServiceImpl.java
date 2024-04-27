package com.wiremock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wiremock.dao.productDao;
import com.wiremock.entity.productEo;
import java.util.List;

@Service
public class productServiceImpl implements productService{

    @Autowired
    private productDao productRepository;
    
    @Override
    public String createProduct(productEo product) {
        if (product == null) {
            return "Product cannot be null";
        }
        productRepository.save(product);
        return "Product added successfully";
    }

    @Override
    public String updateProduct(productEo product) {
        if (product == null) {
            return "Product cannot be null";
        }
        productRepository.save(product);
        return "Product updated successfully";
    }

    @Override
    public String deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            return "Product with ID " + productId + " does not exist";
        }
        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }

    @Override
    public productEo getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<productEo> getAllProducts() {
        return productRepository.findAll();
    }
}
