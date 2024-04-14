package com.productdata.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.productdata.service.ProductService;
import com.productdata.vo.ProductVo;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductVo> createProduct(@RequestBody ProductVo productVo) {
        logger.info("Received POST request to create product: {}", productVo);
        ProductVo createdProductVo = productService.createProduct(productVo);
        if (createdProductVo != null && createdProductVo.getId() != null) {
            logger.info("Product created successfully with ID: {}", createdProductVo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProductVo);
        } else {
            logger.error("Error occurred while creating product");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVo> getProduct(@PathVariable Long id) {
        logger.info("Fetching product with ID: {}", id);
        ProductVo productVo = productService.getProduct(id);
        if (productVo != null) {
            logger.info("Product found with ID: {}", id);
            return ResponseEntity.ok(productVo);
        } else {
            logger.warn("Product not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<ProductVo> getAllProducts() {
        logger.info("Received GET request to retrieve all products");
        List<ProductVo> productVos = productService.getAllProducts();
        logger.info("Retrieved {} products", productVos.size());
        return productVos;
    }
}

