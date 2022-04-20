package com.example.practice.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(){
        super("존재하지 않는 물건입니다.");
    }
}
