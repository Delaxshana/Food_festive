package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodCart extends AppCompatActivity {
    EditText item1,item2,item3,item4;
    //    String [] messages;
    String msg1,msg2,msg3;
    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_cart);
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        Button continue_btn = findViewById(R.id.btn_continue);
        items = new ArrayList<String>();

        Intent intent = getIntent();
        items = (ArrayList<String>) intent.getSerializableExtra("food_items");

        Collections.sort(items);

        msg1 = items.get(0);
        msg2 = items.get(1);
        msg3 = items.get(2);

        item1.setText(msg1);
        item2.setText(msg2);
        item3.setText(msg3);

        continue_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(FoodCart.this,OrderDetails.class);
                startActivity(i1);
            }
        });




    }
}