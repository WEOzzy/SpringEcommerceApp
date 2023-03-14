package com.ecommerce.daos;

import com.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products WHERE product_id = :productId", nativeQuery = true)
    Product findByProductId(@Param("productId") Integer productId);
}
