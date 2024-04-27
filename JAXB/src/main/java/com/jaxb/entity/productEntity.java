package com.jaxb.entity;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class productEntity {

	@XmlAttribute(name="id")
    private Long productId;
	
	@XmlElement(name="productName")
    private String productName;
	
	@XmlElement(name="productPrice")
    private double productPrice;
	
	@XmlElement(name="productCategory")
    private String productCategory;
	
	@XmlElement(name="productBrand")
    private String productBrand;

    public productEntity(Long productId, String productName, double productPrice, String productCategory,
            String productBrand) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public productEntity() {
    }
    
    @Override
	public String toString() {
		return "productEntity [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productCategory=" + productCategory + ", productBrand=" + productBrand + "]";
	}

}   
 
