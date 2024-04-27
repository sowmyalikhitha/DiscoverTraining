package com.mokito.productService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mokito.dao.productDao;
import com.mokito.entity.productEo;
import com.mokito.service.productServiceImpl;

@ExtendWith(MockitoExtension.class) 
public class productServiceImplTest {

	@InjectMocks
	productServiceImpl service;

	@Mock
	private productDao repository;

	    @Test
	    public void testCreateProduct() {
	        productEo product = new productEo();
	        product.setName("Test Product");
	        when(repository.save(product)).thenReturn(product);

	        String result = service.createProduct(product);

	        assertEquals("Product added successfully", result);
	        verify(repository, times(1)).save(product);
	    }

	    @Test
	    public void testUpdateProduct() {
	        productEo product = new productEo();
	        product.setId(1L);
	        product.setName("Updated Test Product");
	        when(repository.save(product)).thenReturn(product);

	        String result = service.updateProduct(product);

	        assertEquals("Product updated successfully", result);
	        verify(repository, times(1)).save(product);
	    }

	    @Test
	    public void testDeleteProduct() {
	        Long productId = 1L;
	        when(repository.existsById(productId)).thenReturn(true);
	        String result = service.deleteProduct(productId);
	        assertEquals("Product deleted successfully", result);
	        verify(repository, times(1)).deleteById(productId);
	    }
	    
	    @Test
	    public void testGetProduct() {
	        Long productId = 1L;
	        productEo product = new productEo();
	        product.setId(productId);
	        when(repository.findById(productId)).thenReturn(java.util.Optional.of(product));

	        productEo retrievedProduct = service.getProduct(productId);

	        assertEquals(product, retrievedProduct);
	        verify(repository, times(1)).findById(productId);
	    }

	    @Test
	    public void testGetAllProducts() {
	        productEo product1 = new productEo();
	        product1.setId(1L);
	        productEo product2 = new productEo();
	        product2.setId(2L);
	        List<productEo> productList = Arrays.asList(product1, product2);
	        when(repository.findAll()).thenReturn(productList);

	        List<productEo> retrievedProducts = service.getAllProducts();

	        assertEquals(productList, retrievedProducts);
	        verify(repository, times(1)).findAll();
	    }
	    
	    @Test
	    public void testCreateProductWithNullProduct() {
	        productEo product = null;
	        String result = service.createProduct(product);
	        assertEquals("Product cannot be null", result);
	        verify(repository, times(0)).save(any());
	    }
	    
	    @Test
	    public void testUpdateProductWithNullProduct() {
	        productEo product = null;
	        String result = service.updateProduct(product);
	        assertEquals("Product cannot be null", result);
	        verify(repository, times(0)).save(any());
	    }

	    @Test
	    public void testGetProductWithNonExistentProductId() {
	        Long nonExistentProductId = 999L;
	        when(repository.findById(nonExistentProductId)).thenReturn(java.util.Optional.empty());
	        productEo retrievedProduct = service.getProduct(nonExistentProductId);
	        assertNull(retrievedProduct);
	        verify(repository, times(1)).findById(nonExistentProductId);
	    }

	    @Test
	    public void testGetAllProductsWithEmptyProductList() {
	        List<productEo> emptyProductList = Collections.emptyList();
	        when(repository.findAll()).thenReturn(emptyProductList);
	        List<productEo> retrievedProducts = service.getAllProducts();
	        assertTrue(retrievedProducts.isEmpty());
	        verify(repository, times(1)).findAll();
	    }

	}
