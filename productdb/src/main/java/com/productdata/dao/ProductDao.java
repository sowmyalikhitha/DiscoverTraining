package com.productdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.productdata.eo.ProductEo;

@Repository
public interface ProductDao extends JpaRepository<ProductEo, Long>{

}

