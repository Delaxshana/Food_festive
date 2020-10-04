package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodCart extends AppCompatActivity {
    EditText item1,item2,item3,item4;
    EditText quantity1, quantity2,quantity3,quantity4;
    EditText size1,size2,size3,size4;
    //    String [] messages;
    String msg1,msg2,msg3;
    List<String> items;
    Map<String,String> items_and_quantities;
    Map<String,String> items_and_sizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_cart);
        //Identifying items
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
//        item4 = findViewById(R.id.item4);
        //Identifying quantities
        quantity1 = findViewById(R.id.quantity1);
        quantity2 = findViewById(R.id.quantity2);
        quantity3 = findViewById(R.id.quantity3);
//        quantity4 = findViewById(R.id.quantity4);
        //Identifying sizes
        size1 = findViewById(R.id.size1);
        size2 = findViewById(R.id.size2);
        size3 = findViewById(R.id.size3);
//        size4 = findViewById(R.id.size4);
        //Initializing maps
        items_and_quantities = new HashMap<String, String>();
        items_and_sizes = new HashMap<String, String>();

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
                //Filling items_and_quantities
                items_and_quantities.put(item1.getText().toString(),quantity1.getText().toString());
                items_and_quantities.put(item2.getText().toString(),quantity2.getText().toString());
                items_and_quantities.put(item3.getText().toString(),quantity3.getText().toString());
                //Fillin items_and_sizes
                items_and_sizes.put(item1.getText().toString(),size1.getText().toString());
                items_and_sizes.put(item2.getText().toString(),size2.getText().toString());
                items_and_sizes.put(item3.getText().toString(),size3.getText().toString());
                //Adding extra to intent
                i1.putExtra("items_and_quantities",(HashMap<String,String>)items_and_quantities);
                i1.putExtra("items_and_sizes",(HashMap<String,String>)items_and_sizes);
                startActivity(i1);
            }
        });




    }
}