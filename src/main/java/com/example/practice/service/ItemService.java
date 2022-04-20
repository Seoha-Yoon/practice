package com.example.practice.service;

import com.example.practice.exceptions.ItemNotFoundException;
import com.example.practice.model.Item;
import com.example.practice.model.dto.ItemDto;
import com.example.practice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemDto> getItems(Long page){
        return itemRepository.findAll().stream()
                .map(i -> new ItemDto(i.getName(), i.getPrice(), i.getStock()))
                .collect(Collectors.toList());
    }

    public ItemDto getItem(long itemId){
        Item item = itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new);
        return new ItemDto(item.getName(), item.getPrice(), item.getStock());
    }

    public ItemDto addItem(String name, int price, int stock){
        Item item = itemRepository.save(new Item(name, price, stock));
        return new ItemDto(item.getName(), item.getPrice(), item.getStock());
    }

    public ItemDto updateItem(long itemId, String name, int price, int stock){
        Item item = itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new);
        item.updateItem(name, price);
        return new ItemDto(item.getName(), item.getPrice(), item.getStock());
    }

    public void deleteItem(long itemId){
        itemRepository.deleteById(itemId);
    }
}
