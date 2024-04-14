package com.productdata.service;

import java.util.List;
import com.productdata.vo.ProductVo;

public interface ProductService {
	ProductVo createProduct(ProductVo productVo);
	ProductVo getProduct(Long productId);
	List<ProductVo> getAllProducts();
}

