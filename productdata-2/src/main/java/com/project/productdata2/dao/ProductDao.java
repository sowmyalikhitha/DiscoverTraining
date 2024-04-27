package com.project.productdata2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.productdata2.eo.ProductEo;

public interface ProductDao extends JpaRepository<ProductEo, Long> {

}

