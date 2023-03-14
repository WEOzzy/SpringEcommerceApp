package com.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "cart_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference(value = "cart_product")
    private Product product;

    private int quantity;

    public Cart() {
    }

    public Cart(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
