package com.project.productdata2.service;

import java.util.List;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.productdata2.bo.ProductBo;
import com.project.productdata2.bo.ProductBoImp;
import com.project.productdata2.controller.ProductControllerImp;
import com.project.productdata2.eo.ProductEo;

@Service
public class ProductServiceImp implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	
    @Autowired
    private ProductBo productBo;

    @Override
    public ProductEo createProduct(ProductEo product) {
        logger.info("Creating product: {}", product);
        ProductEo createdProduct = productBo.createProduct(product);
        logger.info("Product created successfully with ID: {}", createdProduct.getId());
        return createdProduct;
    }

    @Override
    public ProductEo getProduct(Long productId) {
        logger.info("Retrieving product with ID: {}", productId);
        ProductEo product = productBo.getProduct(productId);
        if (product != null) {
            logger.info("Product retrieved successfully: {}", product);
        } else {
            logger.info("Product with ID {} not found", productId);
        }
        return product;
    }

    @Override
    public List<ProductEo> getAllProducts() {
        logger.info("Retrieving all products");
        List<ProductEo> products = productBo.getAllProducts();
        logger.info("Retrieved {} products", products.size());
        return products;
    }
}
