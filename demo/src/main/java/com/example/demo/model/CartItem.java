package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    private int quantity;
    private double priceAtAddTime;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart cart;

    @ManyToOne
    @JoinColumn(name = "spider_id")
    private Spider spider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceAtAddTime() {
        return priceAtAddTime;
    }

    public void setPriceAtAddTime(double priceAtAddTime) {
        this.priceAtAddTime = priceAtAddTime;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Spider getSpider() {
        return spider;
    }

    public void setSpider(Spider spider) {
        this.spider = spider;
    }

}
