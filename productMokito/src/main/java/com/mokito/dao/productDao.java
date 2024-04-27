package com.mokito.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mokito.entity.productEo;

@Repository
public interface productDao extends JpaRepository<productEo, Long>{

}


