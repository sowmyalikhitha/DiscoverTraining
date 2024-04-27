package com.wiremock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wiremock.entity.productEo;

@Repository
public interface productDao extends JpaRepository<productEo, Long>{

}



