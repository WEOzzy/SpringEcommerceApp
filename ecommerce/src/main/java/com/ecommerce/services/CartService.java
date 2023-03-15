package com.ecommerce.services;

import com.ecommerce.daos.CartDAO;
import com.ecommerce.daos.ProductDAO;
import com.ecommerce.daos.UserDAO;
import com.ecommerce.models.Cart;
import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    private final CartDAO cartDAO;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;

    public CartService(CartDAO cartDAO, ProductDAO productDAO, UserDAO userDAO) {
        this.cartDAO = cartDAO;
        this.productDAO = productDAO;
        this.userDAO = userDAO;
    }

    public Product findByProductId(int productId) {
        return productDAO.findByProductId(productId);
    }

    public Map<Product, Integer> getCart(int userId) {
        Map<Product, Integer> cartMap = new HashMap<>();
        List<Cart> cartItems = cartDAO.getCart(userId);

        for (Cart cart : cartItems) {
            // optionally create a cartItem model that contains product id, title, price to reduce unnecessary data
            cartMap.put(cart.getProduct(), cart.getQuantity());
        }

        return cartMap;
    }

    public void clearCart(int userId) {
        cartDAO.clearCart(userId);
    }

    // TODO: decide later if I want to actually return a cart list for this or keep it void
    public void addCartItem(User user, int productId, int quantity) {
        Optional<Cart> cartItem = cartDAO.getCartItem(user.getUserId(), productId);
        Product product = productDAO.findByProductId(productId);
        if (!cartItem.isPresent()) {
            cartDAO.save(new Cart(user, product, quantity));
        } else {
            // if this doesn't work create new cart from optional, update quantity there and save
            cartItem.get().setQuantity(quantity + cartItem.get().getQuantity());
            cartDAO.save(cartItem.get());
        }

    }

    public User getCartUser(int userId) {
        Optional<User> user = userDAO.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else return null;
    }
}
