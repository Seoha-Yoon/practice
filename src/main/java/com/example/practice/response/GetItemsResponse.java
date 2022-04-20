package com.example.practice.response;

import com.example.practice.model.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetItemsResponse {
    List<ItemDto> items;
}
