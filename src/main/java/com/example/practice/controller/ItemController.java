package com.example.practice.controller;

import com.example.practice.model.dto.ItemDto;
import com.example.practice.request.ItemRequest;
import com.example.practice.response.GetItemResponse;
import com.example.practice.response.GetItemsResponse;
import com.example.practice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetItemsResponse getItems(@RequestParam Long page){
        List<ItemDto> items = itemService.getItems(page);
        return new GetItemsResponse(items);
    }

    @GetMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public GetItemResponse getItem(@PathVariable long itemId){
        ItemDto item = itemService.getItem(itemId);
        return new GetItemResponse(item);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetItemResponse addItem(@RequestBody ItemRequest itemRequest){
        ItemDto item = itemService.addItem(itemRequest.getName(), itemRequest.getPrice(), itemRequest.getStock());
        return new GetItemResponse(item);
    }

    @PutMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public GetItemResponse updateItem(@PathVariable long itemId, @RequestBody ItemRequest request){
        ItemDto item = itemService.updateItem(itemId,
                request.getName(),
                request.getPrice(),
                request.getStock());
        return new GetItemResponse(item);
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable long itemId){
        itemService.deleteItem(itemId);
    }
}
