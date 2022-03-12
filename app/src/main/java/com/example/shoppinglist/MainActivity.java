package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button displayList, addToList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayList = findViewById(R.id.viewList);
        addToList = findViewById(R.id.addList);

        displayList.setOnClickListener(this);
        addToList.setOnClickListener(this);
    }

    private void showList(){
        Intent intent = new Intent(this, DisplayList.class);
        startActivity(intent);
    }

    private void addList() {
        Intent intent = new Intent(this, AddToList.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.addList:
                addList();
                break;
            case R.id.viewList:
                showList();
                break;
        }
    }
}

