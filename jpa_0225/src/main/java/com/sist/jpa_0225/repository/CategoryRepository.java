package com.sist.jpa_0225.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.jpa_0225.store.Category1JPO;

@Repository
public interface CategoryRepository extends JpaRepository<Category1JPO, Long>{

}
