package com.productdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.productdata.feignclient.ProductFeignClient;
import com.productdata.vo.ProductVo;

@Service
public class ProductOrderServiceImp implements ProductOrderService {

	@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignClient productFeignClient;

    private static final String PRODUCT_SERVICE_URL = "http://localhost:8080"; // Assuming first application runs on port 8080

    @Override
    public ResponseEntity<ProductVo> retrieveProductUsingRestTemplate(Long id) {
        String url = PRODUCT_SERVICE_URL + "/products/" + id;
        ResponseEntity<ProductVo> response = restTemplate.getForEntity(url, ProductVo.class);
        return response;
    }

    @Override
    public ResponseEntity<ProductVo> retrieveProductUsingFeignClient(Long id) {
        return productFeignClient.getProduct(id);
    }

}
