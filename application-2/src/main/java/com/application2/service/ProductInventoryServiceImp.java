package com.application2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.application2.entity.ProductInventoryEo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class ProductInventoryServiceImp implements ProductInventoryService {

	@Autowired
    private RestTemplate restTemplate;
    
	private static final String PRODUCT_SERVICE = "product-service";
    private static final String PRODUCT_SERVICE_URL = "http://localhost:1000";

    @Override
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "productServiceFallBack")
    public ResponseEntity<ProductInventoryEo> retrieveProductUsingRestTemplate(Long id) {
        String url = PRODUCT_SERVICE_URL + "/products/" + id;
        ResponseEntity<ProductInventoryEo> response = restTemplate.getForEntity(url, ProductInventoryEo.class);
        return response;
    }
    
    public ResponseEntity<ProductInventoryEo> productServiceFallBack(Exception productException){
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProductInventoryEo());
    }

}
