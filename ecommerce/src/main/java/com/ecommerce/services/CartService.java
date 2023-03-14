package com.ecommerce.services;

import com.ecommerce.daos.CartDAO;
import com.ecommerce.daos.ProductDAO;
import com.ecommerce.models.Product;


public class CartService {

    private final CartDAO cartDAO;
    private final ProductDAO productDAO;

    public CartService(CartDAO cartDAO, ProductDAO productDAO) {
        this.cartDAO = cartDAO;
        this.productDAO = productDAO;
    }

    public Product findByProductId(int productId) {
        return productDAO.findByProductId(productId);
    }
}
