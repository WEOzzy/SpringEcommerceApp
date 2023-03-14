package com.ecommerce.daos;

import com.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {


}
