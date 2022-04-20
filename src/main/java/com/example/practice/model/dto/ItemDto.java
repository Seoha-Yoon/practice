package com.example.practice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {
    private String name;
    private int price;
    private int stock;
}
