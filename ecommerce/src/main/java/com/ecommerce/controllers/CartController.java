package com.ecommerce.controllers;

import com.ecommerce.models.CartItem;
import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import com.ecommerce.services.CartService;
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

    @GetMapping
    public ResponseEntity<Map<Product, Integer>> getCart(@RequestBody User user) {
        System.out.println("Get cart endpoint hit");
        return ResponseEntity.ok(cartService.getCart(user.getUserId()));
    }

    @PostMapping(value = "/checkout")
    public ResponseEntity<String> checkout(@RequestBody User user) {
        // all this currently does is clear the cart
        System.out.println("Checkout endpoint hit");
        cartService.clearCart(user.getUserId());
        return ResponseEntity.ok("Checkout complete");
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addItemToCart(@RequestBody CartItem item) {
        User user = cartService.getCartUser(item.getUserId());
        cartService.addCartItem(user, item.getProductId(), item.getQuantity());
        return ResponseEntity.ok("Successfully added to cart");
    }
}
