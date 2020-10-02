package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addItem extends AppCompatActivity {
    private EditText itemName,itemType,itemPrice,itemDesc;
    private Button add,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemName = (EditText)findViewById(R.id.itemName);
        itemType = (EditText)findViewById(R.id.itemType);
        itemPrice = (EditText)findViewById(R.id.itemPrice);
        itemDesc = (EditText)findViewById(R.id.itemDesc);
        add = (Button)findViewById(R.id.add);
        back = (Button)findViewById(R.id.back);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addItem.this,adminDashboard.class);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addItem.this,adminDashboard.class);
            }
        });
    }
}