package com.ecommerce.controllers;

import com.ecommerce.annotations.Authorized;
import com.ecommerce.models.CartItem;
import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import com.ecommerce.services.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Authorized
    @GetMapping // TODO: no longer need RequestBody
    public ResponseEntity<Map<Product, Integer>> getCart(HttpSession session, @RequestBody User user) {
        System.out.println("Get cart endpoint hit");
        //((User)session.getAttribute("user")).getUserId()
        return ResponseEntity.ok(cartService.getCart(((User)session.getAttribute("user")).getUserId()));
//        return ResponseEntity.ok(cartService.getCart(user.getUserId()));
    }

    @Authorized
    @PostMapping(value = "/checkout") // TODO: no longer need RequestBody
    public ResponseEntity<String> checkout(HttpSession session, @RequestBody User user) {
        // all this currently does is clear the cart
        System.out.println("Checkout endpoint hit");
        cartService.clearCart(((User)session.getAttribute("user")).getUserId());
        //cartService.clearCart(user.getUserId());
        return ResponseEntity.ok("Checkout complete");
    }

    @Authorized
    @PostMapping(value = "/add") // TODO: change RequestBody, CartItem no longer needs user id
    public ResponseEntity<String> addItemToCart(HttpSession session, @RequestBody CartItem item) {
        User user = cartService.getCartUser(((User)session.getAttribute("user")).getUserId());
        //User user = cartService.getCartUser(item.getUserId());
        cartService.addCartItem(user, item.getProductId(), item.getQuantity());
        return ResponseEntity.ok("Successfully added to cart");
    }
}
