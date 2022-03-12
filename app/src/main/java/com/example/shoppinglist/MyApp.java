package com.example.shoppinglist;

import android.app.Application;

import java.util.HashMap;

public class MyApp extends Application {

    private ShoppingList shoppingList = new ShoppingList();

    public HashMap<String, Boolean> getShoppingList(){
        return this.shoppingList.getList();
    }

    public void addToList(String item){
        this.shoppingList.addToList(item);
    }

}
