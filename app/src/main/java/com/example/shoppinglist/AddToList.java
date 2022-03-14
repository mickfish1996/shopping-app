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
        if(shoppingList.getList().containsKey(textBox.getText().toString())) {
            this.shoppingList.addToList(textBox.getText().toString());
            createNewCheckBoxes(textBox.getText().toString(), shoppingList.getList().size());
            textBox.setText("");
        }

    }
    private void createNewCheckBoxes(String key, int size){

        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.checkboxes);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setId(size + 1);
        checkBox.setText(key);

        LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        checkParams.setMargins(10,10,10,10);
        checkParams.gravity = Gravity.LEFT;

        parentLayout.addView(checkBox, checkParams);


    }
    private void createCheckBoxes() {
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.checkboxes);
        int id = 1;
        HashMap<String, Boolean>list = shoppingList.getList();
        for (HashMap.Entry<String, Boolean> set :
             list.entrySet()){
            CheckBox checkBox = new CheckBox(this);

            checkBox.setId(id);

            boolean checked = set.getValue();

            System.out.println(set.getKey());
            checkBox.setTextColor(Color.BLACK);
            if (checked){
                checkBox.setChecked(false);
            } else {
                checkBox.setChecked(true);
            }

            LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
            checkParams.setMargins(10,10,10,10);
            checkParams.gravity = Gravity.LEFT;

            parentLayout.addView(checkBox, checkParams);

            id++;
        }






    }

}