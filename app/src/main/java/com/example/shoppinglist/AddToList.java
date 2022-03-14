package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.HashMap;


public class AddToList extends AppCompatActivity implements View.OnClickListener {

    ShoppingList shoppingList;
    Button addList;
    EditText textBox;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);
        shoppingList = new ShoppingList();

        addList = findViewById(R.id.addItem);
        textBox = findViewById(R.id.editTextTextPersonName2);
        text = textBox.getText().toString();
        addList.setOnClickListener(this);
        createCheckBoxes();

    }

    @Override
    public void onClick(View v)
    {
        this.shoppingList.addToList(text);
        textBox.setText("");
        createCheckBoxes();
    }

    private void createCheckBoxes() {
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.checkboxes);
        int id = 1;
        HashMap<String, Boolean>list = shoppingList.getList();
        for (HashMap.Entry<String, Boolean> set :
             list.entrySet()){
            CheckBox checkBox = new CheckBox(this);

            checkBox.setId(id);

            String text = set.getKey();
            boolean checked = set.getValue();

            System.out.println(text);
            checkBox.setTextColor(Color.BLACK);
            if (checked){
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }

            LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
            checkParams.setMargins(10,10,10,10);
            checkParams.gravity = Gravity.LEFT;

            parentLayout.addView(checkBox, checkParams);

            id++;
        }






    }

}