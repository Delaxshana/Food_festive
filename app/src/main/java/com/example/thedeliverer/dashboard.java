package com.example.thedeliverer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity {
    List<String> food_items;
    TextView item1,item2,item3,item4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button item1_btn = (Button) this.findViewById(R.id.food_item1_btn);
        Button item2_btn = (Button) this.findViewById(R.id.food_item2_btn);
        Button item3_btn = (Button) this.findViewById(R.id.food_item3_btn);
        Button item4_btn = (Button) this.findViewById(R.id.food_item4_btn);
        item1 = findViewById(R.id.textViewItem1);
        item2 = findViewById(R.id.textViewItem2);
        item3 = findViewById(R.id.textViewItem3);
        item4 = findViewById(R.id.textViewItem4);
        food_items = new ArrayList<String>();

        item1_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                food_items.add(item1.getText().toString());
            }
        });
        item2_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                food_items.add(item2.getText().toString());
            }
        });
        item3_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                food_items.add(item3.getText().toString());
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent1 = new Intent(dashboard.this,dashboard.class);
                startActivity(intent1);
                return true;
            case R.id.navigation_search:
                Intent intent2 = new Intent(dashboard.this,dashboard.class);
                startActivity(intent2);
                return true;
            case R.id.navigation_cart:
                Intent intent3 = new Intent(dashboard.this,FoodCart.class);
                intent3.putExtra("food_items",(ArrayList<String>)food_items);
                startActivity(intent3);
                return true;
            case R.id.navigation_user:
                Intent intent4 = new Intent(dashboard.this,user.class);
                startActivity(intent4);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}