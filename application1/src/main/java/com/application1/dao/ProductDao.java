package com.application1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.application1.entity.ProductEo;

@Repository
public interface ProductDao extends JpaRepository<ProductEo, Long>{

}
