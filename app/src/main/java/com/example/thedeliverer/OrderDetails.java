package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDetails extends AppCompatActivity {
    TextView food_item1,food_item2,food_item3,food_item4;
    EditText food_quantity1,food_quantity2,food_quantity3,food_quantity4;
    EditText food_size1,food_size2,food_size3,food_size4;
    EditText item_name,item_quantity,item_size;
    String item1,item2,item3;
    String items1,items2,items3;
    String quantity1,quantity2, quantity3;
    String size1,size2,size3;
    Map<String,String> items_quantities;
    Map<String,String> items_sizes;
    EditText special_instructions_txt;
//    TableRow row1,row2,row3,row4;
    Button edit_btn,delete_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        //Initializing items
        food_item1 = findViewById(R.id.food_item1);
        food_item2 = findViewById(R.id.food_item2);
        food_item3 = findViewById(R.id.food_item3);
        food_item4 = findViewById(R.id.food_item4);
        //Initializing quantities
        food_quantity1 = findViewById(R.id.food_quantity1);
        food_quantity2 = findViewById(R.id.food_quantity2);
        food_quantity3 = findViewById(R.id.food_quantity3);
        food_quantity4 = findViewById(R.id.food_quantity4);
        //Initializing sizes
        food_size1 = findViewById(R.id.food_size1);
        food_size2 = findViewById(R.id.food_size2);
        food_size3 = findViewById(R.id.food_size3);
        food_size4 = findViewById(R.id.food_size4);
        //Initializing special instructions
        special_instructions_txt = findViewById(R.id.special_inst_txt);
        //Initializing rows
//        row1 = findViewById(R.id.row1);
//        row2 = findViewById(R.id.row2);
//        row3 = findViewById(R.id.row3);
//        row4 = findViewById(R.id.row4);
        //Initializing second table values
        item_name = findViewById(R.id.item_name);
        item_quantity = findViewById(R.id.item_quantity);
        item_size = findViewById(R.id.item_size);
        //Initializing maps
        items_quantities = new HashMap<String, String>();
        items_sizes = new HashMap<String, String>();
        //String array
        item1 = null;
        item2 = null;
        item3 = null;
        String items[] = {};
        String quantities[] = {};
        //int i =0;

        Button continue_btn = findViewById(R.id.continue_button);
        edit_btn = findViewById(R.id.edit_btn);
        edit_btn.setVisibility(View.INVISIBLE);
        delete_btn = findViewById(R.id.delete_btn);
        delete_btn.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        DBHelper dbHelper = new DBHelper(this);

        items_quantities= dbHelper.readAllcartsInfo("items_and_quantities");
        items_sizes = dbHelper.readAllcartsInfo("items_and_sizes");
//        items_quantities = (HashMap<String, String>) intent.getSerializableExtra("items_and_quantities");
//        items_sizes = (HashMap<String, String>)intent.getSerializableExtra("items_and_sizes");

        for (String key:items_quantities.keySet()){
            if (item1 == null){
                item1 = key;
                quantity1 = items_quantities.get(key);
                continue;
            }

            if(item1!=null && item2 == null){
                item2 = key;
                quantity2 = items_quantities.get(key);
                continue;
            }

            if (item1 != null && item2!=null && item3==null){
                item3 = key;
                quantity3 = items_quantities.get(key);
                break;
            }
//            quantities[i] = items_quantities.get(key);
        }

        for (String key:items_sizes.keySet()){
            if (items1 == null){
                items1 = key;
                size1 = items_sizes.get(key);
                continue;
            }

            if(items1!=null && items2 == null){
                items2 = key;
                size2 = items_sizes.get(key);
                continue;
            }

            if (items1 != null && items2!=null && items3==null){
                items3 = key;
                size3 = items_sizes.get(key);
                break;
            }
//            quantities[i] = items_quantities.get(key);
        }

        food_item1.setText(item1);
//        food_item1.setEnabled(false);
        food_item2.setText(item2);
//        food_item2.setEnabled(false);
        food_item3.setText(item3);
//        food_item3.setEnabled(false);

        food_quantity1.setText(quantity1);
        food_quantity1.setEnabled(false);
        food_quantity2.setText(quantity2);
        food_quantity2.setEnabled(false);
        food_quantity3.setText(quantity3);
        food_quantity3.setEnabled(false);

        food_size1.setText(size1);
        food_size1.setEnabled(false);
        food_size2.setText(size2);
        food_size2.setEnabled(false);
        food_size3.setText(size3);
        food_size3.setEnabled(false);

//        food_item1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                item_name.setText(food_item1.getText().toString());
//                item_quantity.setText(food_quantity1.getText().toString());
//                item_size.setText(size1);
//            }
//        });
//
//        food_item2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                item_name.setText(food_item2.getText().toString());
//                item_quantity.setText(food_quantity2.getText().toString());
//                item_size.setText(size2);
//            }
//        });
//
//        food_item3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                item_name.setText(food_item3.getText().toString());
//                item_quantity.setText(food_quantity3.getText().toString());
//                item_size.setText(size3);
//            }
//        });





        continue_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(OrderDetails.this,OrderConfirmation.class);
                i1.putExtra("special_inst",special_instructions_txt.getText().toString());
                startActivity(i1);
            }
        });
    }

    public void setRowDetails1(View view){
        item_name.setText(food_item1.getText().toString());
        item_quantity.setText(food_quantity1.getText().toString());
        item_size.setText(food_size1.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    public void setRowDetails2(View view){
        item_name.setText(food_item2.getText().toString());
        item_quantity.setText(food_quantity2.getText().toString());
        item_size.setText(food_size2.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    public void setRowDetails3(View view){
        item_name.setText(food_item3.getText().toString());
        item_quantity.setText(food_quantity3.getText().toString());
        item_size.setText(food_size3.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    public void deleteData(View view){
        DBHelper dbHelper = new DBHelper(this);

        dbHelper.deleteCartInfo(item_name.getText().toString());

        Intent i1 = new Intent(OrderDetails.this,OrderDetails.class);

        Toast.makeText(this, item_name.getText().toString() + " deleted Successfully", Toast.LENGTH_SHORT).show();

        startActivity(i1);

    }

    public void updateData(View view){
        DBHelper dbHelper = new DBHelper(this);

        int val = dbHelper.updateCartInfo(item_name.getText().toString(),item_quantity.getText().toString(),item_size.getText().toString());

        Intent i2 = new Intent(OrderDetails.this,OrderDetails.class);
        if (val>0){
            Toast.makeText(this, "Data updates successfully", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Data did not update!", Toast.LENGTH_SHORT).show();
        }

        startActivity(i2);

    }



//    public void readCartInfo(View view){
//
//
//        Toast.makeText(this,unames.toString(), Toast.LENGTH_SHORT).show();
//    }


}