package com.ecommerce.daos;

import com.ecommerce.models.Cart;
import com.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartDAO extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT * FROM cart WHERE user_id = :userId", nativeQuery = true)
    List<Cart> getCart(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM cart WHERE user_id = :userId AND product_id = :productId", nativeQuery = true)
    Optional<Cart> getCartItem(@Param("userId") Integer userId, @Param("productId") Integer productId);

    // TODO: add functionality for removing items/emptying cart (optional)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cart WHERE user_id = :userId", nativeQuery = true)
    void clearCart(@Param("userId") Integer userId);
}
