package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;



@Entity
public class Spider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spiderId;
    private String spiderName; 
    private double price;
    private String description;


    //getters and setters

    public Integer getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(Integer spiderId){
        this.spiderId = spiderId;
    }

    public String getSpiderName(){
        return spiderName;
    }

    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
