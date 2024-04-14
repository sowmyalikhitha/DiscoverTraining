package com.productdata.bo;

import java.util.List;
import com.productdata.eo.ProductEo;

public interface ProductBo {
	List<ProductEo> getAllProducts();
	ProductEo getProduct(Long productId);
	ProductEo createProduct(ProductEo product);
}