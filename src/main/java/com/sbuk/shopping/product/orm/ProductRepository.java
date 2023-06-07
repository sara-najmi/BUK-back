package com.sbuk.shopping.product.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT COUNT(id) FROM PRODUCT", nativeQuery = true)
    Integer countAll();
}
