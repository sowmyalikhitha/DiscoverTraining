package com.wiremock.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiremock.entity.productEo;
import com.wiremock.service.productService;


@RestController
@RequestMapping("/products")
public class productController {
	productService service;
	
	public productController(productService service) {
		this.service = service;
	}

	@GetMapping("/{productId}")
	public productEo getProductDetails(@PathVariable Long productId) {
		return service.getProduct(productId);
	}
	
	@GetMapping("/getAll")
	public List<productEo> getAllProductsDetails() {
		return service.getAllProducts();
	}
	
	@PostMapping
	public String createProductDetails(@RequestBody productEo products) {
		service.createProduct(products);
		return "product details successfully added";
	}
	
	@PutMapping("/edit")
    public String updateProductDetails(@RequestBody productEo products) {
		service.updateProduct(products);
        return "Product details successfully updated";
    }
	
	@DeleteMapping("delete/{productId}")
	public String updateProductDetails(@PathVariable Long productId) {
		service.deleteProduct(productId);
		return "product details successfully deleted";
	}
}



