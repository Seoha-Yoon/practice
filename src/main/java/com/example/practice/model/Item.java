package com.example.practice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;

    private int price;
    private int stock;

    public Item(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void updateItem(String name, int price){
        this.name = name;
        this.price = price;
    }
}
