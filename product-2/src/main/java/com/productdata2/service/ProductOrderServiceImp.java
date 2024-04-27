package com.productdata2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.productdata2.eo.ProductEo;
import com.productdata2.feignclient.ProductFeignClient;

@Service
public class ProductOrderServiceImp implements ProductOrderService {

	@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignClient productFeignClient;
    

    private static final String PRODUCT_SERVICE_URL = "http://localhost:8080";

    @Override
    public ResponseEntity<ProductEo> retrieveProductUsingRestTemplate(Long id) {
        String url = PRODUCT_SERVICE_URL + "/products/" + id;
        ResponseEntity<ProductEo> response = restTemplate.getForEntity(url, ProductEo.class);
        return response;
    }

    @Override
    public ResponseEntity<ProductEo> retrieveProductUsingFeignClient(Long id) {
        return productFeignClient.getProduct(id);
    }

}
