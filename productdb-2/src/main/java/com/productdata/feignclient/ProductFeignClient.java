package com.productdata.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.productdata.vo.ProductVo;

@FeignClient(name = "productdb-1", url = "http://localhost:8080") // Assuming first application runs on port 8080
public interface ProductFeignClient {

    @GetMapping("/products/{id}")
    ResponseEntity<ProductVo> getProduct(@PathVariable("id") Long id);
}
