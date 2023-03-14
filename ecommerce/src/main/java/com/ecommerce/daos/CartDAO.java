package com.ecommerce.daos;

import com.ecommerce.models.Cart;
import com.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDAO extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT * FROM cart WHERE user_id = :userId", nativeQuery = true)
    List<Cart> getCart(@Param("userId") Integer userId);

    // TODO: add functionality for removing items/emptying cart (optional)
}
