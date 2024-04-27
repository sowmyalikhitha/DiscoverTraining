package com.project.productdata2.bo;

import com.project.productdata2.eo.ProductEo;
import java.util.List;

public interface ProductBo {
    ProductEo createProduct(ProductEo product);
    ProductEo getProduct(Long productId);
    List<ProductEo> getAllProducts();
}