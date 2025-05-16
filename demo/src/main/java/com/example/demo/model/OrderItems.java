package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderitems")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemsId;

    // Each order item belongs to ONE order
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    // Each order item is linked to ONE spider (the product being sold)
    @ManyToOne
    @JoinColumn(name = "spiderId")
    private Spider spider;

    private int quantity;
    private double price; // Snapshot price (in case spider price changes later)

    public OrderItems() {
    }

    public OrderItems(Order order, Spider spider, int quantity, double price) {
        this.order = order;
        this.spider = spider;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public Long getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(Long orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Spider getSpider() {
        return spider;
    }

    public void setSpider(Spider spider) {
        this.spider = spider;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
