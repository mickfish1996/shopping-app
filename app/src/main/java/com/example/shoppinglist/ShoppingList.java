package com.example.shoppinglist;

import java.io.Serializable;
import java.util.HashMap;
import android.view.View;
import android.widget.Button;

public class ShoppingList implements Serializable {
    HashMap<String, Boolean> shoppingList = new HashMap<String, Boolean>();

    public ShoppingList(){

    }

    public void addToList(String item) {
        shoppingList.put(item, true);
    }

    public HashMap<String, Boolean> getList(){
        return shoppingList;
    }
}
