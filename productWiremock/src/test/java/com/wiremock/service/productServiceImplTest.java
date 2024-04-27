package com.wiremock.service;                                                                                                
                                                                                                                                                                                                                                   
        
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.wiremock.entity.productEo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static com.github.tomakehurst.wiremock.client.WireMock.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)                                                  
public class productServiceImplTest {                                                                                        
                                                                                                                             
    @Autowired                                                                                                               
    private productServiceImpl productService;                                                                               
                                                                                                                             
    @LocalServerPort                                                                                                         
    private int port;                                                                                                        
                                                                                                                             
    private static WireMockServer wireMockServer;                                                                            
                                                                                                                             
    @BeforeAll                                                                                                               
    static void setup() {                                                                                                    
        wireMockServer = new WireMockServer(8080);                                                                           
        wireMockServer.start();                                                                                              
        WireMock.configureFor("localhost", wireMockServer.port());                                                           
    }                                                                                                                        
                                                                                                                             
    @AfterAll                                                                                                                
    static void tearDown() {                                                                                                 
        wireMockServer.stop();                                                                                               
    }                                                                                                                        
                                                                                                                             
    @Test                                                                                                                    
    void testCreateProduct() {                                                                                               
        // Stubbing the POST request to create a product                                                                     
        stubFor(post(urlEqualTo("/products"))                                                                                
                .willReturn(aResponse().withStatus(200).withBody("Product added successfully")));                            
                                                                                                                             
        // Prepare a sample product for creation                                                                             
        productEo productToAdd = new productEo();                                                                            
        productToAdd.setName("iphone");                                                                                      
        productToAdd.setPrice(100.0);                                                                                        
                                                                                                                             
        // Test the createProduct method                                                                                     
        String response = productService.createProduct(productToAdd);                                                        
        assertEquals("Product added successfully", response);                                                                
    }                                                                                                                        
                                                                                                                             
    @Test                                                                                                                    
    void testUpdateProduct() {                                                                                               
        // Stubbing the PUT request to update a product                                                                      
        stubFor(put(urlEqualTo("/products"))                                                                                 
                .willReturn(aResponse().withStatus(200).withBody("Product updated successfully")));                          
                                                                                                                             
        // Test the updateProduct method                                                                                     
        String response = productService.updateProduct(new productEo());                                                     
        assertEquals("Product updated successfully", response);                                                              
    }                                                                                                                        
                                                                                                                             
    @Test                                                                                                                    
    void testDeleteProduct() {                                                                                               
        // Stubbing the DELETE request to delete a product                                                                   
        stubFor(delete(urlEqualTo("/products/1"))                                                                            
                .willReturn(aResponse().withStatus(200).withBody("Product deleted successfully")));                          
                                                                                                                             
        // Test the deleteProduct method                                                                                     
        String response = productService.deleteProduct(1L);                                                                  
        assertEquals("Product deleted successfully", response);                                                              
    }                                                                                                                        
                                                                                                                             
    @Test                                                                                                                    
    void testGetProduct() {                                                                                                  
        // Stubbing the GET request to retrieve a product                                                                    
        stubFor(get(urlEqualTo("/products/1"))                                                                               
                .willReturn(aResponse().withStatus(200).withBody("{\"id\":1,\"name\":\"Test Product\",\"price\":100.0}")));  
                                                                                                                             
        // Test the getProduct method                                                                                        
        productEo product = productService.getProduct(1L);                                                                   
                                                                                                                             
        assertEquals(1L, product.getId());                                                                                   
        assertEquals("iphone", product.getName());                                                                     
        assertEquals(100.0, product.getPrice());                                                                             
    }                                                                                                                        
                                                                                                                             
    @Test                                                                                                                    
    void testGetAllProducts() {                                                                                              
        // Stubbing the GET request to retrieve all products                                                                 
    	 stubFor(get(urlEqualTo("/products"))
    	            .willReturn(aResponse().withStatus(200).withBody("[{\"id\":1,\"name\":\"Test Product\",\"price\":100.0}, {\"id\":2,\"name\":\"Another Product\",\"price\":200.0}]")));
                                                                                                                             
        // Test the getAllProducts method                                                                                    
        List<productEo> products = productService.getAllProducts();                                                          
                                                                                                                             
        assertEquals(1, products.size());                                                                                    
        assertEquals(1L, products.get(0).getId());                                                                           
        assertEquals("Test Product", products.get(0).getName());                                                             
        assertEquals(100.0, products.get(0).getPrice());                                                                     
    }                                                                                                                        
}                                                                                                                            
                                                                                                                             



































































































