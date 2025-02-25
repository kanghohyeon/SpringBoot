package com.sist.jpa_0225.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.jpa_0225.store.ProductJPO;

@Repository
public interface ProductRepository extends JpaRepository<ProductJPO, Long>{


}
