package com.example.shoppinglist;

import java.util.HashMap;

public class ShoppingList {
    HashMap<String, Boolean> shoppingList = new HashMap<String, Boolean>();

    public ShoppingList(){

    }

    public void addToList(String item, boolean num){
        shoppingList.put(item, num);
    }

    public HashMap<String, Boolean> getList(){
        return shoppingList;
    }
}
