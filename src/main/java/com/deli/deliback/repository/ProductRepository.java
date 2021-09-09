package com.deli.deliback.repository;

import com.deli.deliback.dto.ProductListDto;
import com.deli.deliback.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>,ProductRepositoryCustom, QuerydslPredicateExecutor<Product> {
    List<ProductListDto> findByProductnameContaining(String keyword);
}
