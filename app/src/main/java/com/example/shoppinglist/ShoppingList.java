package com.example.shoppinglist;

import java.util.HashMap;

public class ShoppingList {
    HashMap<String, Integer> shoppingList = new HashMap<String, Integer>();

    public ShoppingList(){

    }

    public void addToList(String item, int num){
        shoppingList.put(item, num);
    }

    public HashMap<String, Integer> getList(){
        return shoppingList;
    }
}
