package com.example.practice.response;

import com.example.practice.model.Item;
import com.example.practice.model.dto.ItemDto;
import lombok.Getter;

@Getter
public class GetItemResponse {
    private String name;
    private int price;
    private int stock;

    public GetItemResponse(ItemDto item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.stock = item.getStock();
    }
}
