package com.productdata.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.productdata.bo.ProductBo;
import com.productdata.eo.ProductEo;
import com.productdata.mapper.ProductMapper;
import com.productdata.vo.ProductVo;

@Service
public class ProductServiceImp implements ProductService {
    
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
    
    @Autowired
    private ProductBo productBo;
    
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductVo createProduct(ProductVo productVo) {
        logger.info("Creating product: {}", productVo);
        ProductEo productEo = productMapper.VotoEo(productVo); 
        ProductEo createdProductEo = productBo.createProduct(productEo);
        if (createdProductEo != null && createdProductEo.getId() != null) {
            logger.info("Product created successfully with ID: {}", createdProductEo.getId());
            return productMapper.EotoVo(createdProductEo); // Map ProductEo to ProductVo
        } else {
            logger.error("Failed to create product");
            return null;
        }
    }

    @Override
    public ProductVo getProduct(Long productId) {
        logger.info("Retrieving product with ID: {}", productId);
        ProductEo productEo = productBo.getProduct(productId);
        if (productEo != null) {
            logger.info("Product retrieved successfully: {}", productEo);
            return productMapper.EotoVo(productEo); 
        } else {
            logger.info("Product with ID {} not found", productId);
            return null;
        }
    }

    @Override
    public List<ProductVo> getAllProducts() {
        logger.info("Retrieving all products");
        List<ProductEo> productEos = productBo.getAllProducts();
        List<ProductVo> productVos = productMapper.EotoVoList(productEos); // Map List<ProductEo> to List<ProductVo>
        logger.info("Retrieved {} products", productVos.size());
        return productVos;
    }
}
