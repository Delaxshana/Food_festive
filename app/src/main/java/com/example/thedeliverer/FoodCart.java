package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelper;

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
    String item_name1,item_name2,item_name3,item_name4,item_quantity1,item_quantity2,item_quantity3,item_quantity4,item_size1,item_size2,item_size3,item_size4;
    List<String> items;
    List<String> itemNames;
    Map<String,String> items_and_quantities;
    Map<String,String> items_and_sizes;
    String ID1,ID2,ID3,ID4;
    int size;
    String cart_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_cart);
        //Identifying items
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        //Identifying quantities
        quantity1 = findViewById(R.id.quantity1);
        quantity2 = findViewById(R.id.quantity2);
        quantity3 = findViewById(R.id.quantity3);
        quantity4 = findViewById(R.id.quantity4);
        //Identifying sizes
        size1 = findViewById(R.id.size1);
        size2 = findViewById(R.id.size2);
        size3 = findViewById(R.id.size3);
        size4 = findViewById(R.id.size4);
        //Initializing maps
        items_and_quantities = new HashMap<String, String>();
        items_and_sizes = new HashMap<String, String>();

        ID1 = ID2 =ID3 = ID4 = null;

        Button continue_btn = findViewById(R.id.btn_continue);
        items = new ArrayList<String>();
        itemNames = new ArrayList<String>();

        Intent intent = getIntent();
        items = (ArrayList<String>) intent.getSerializableExtra("food_items");

        Collections.sort(items);

        size = items.size();
        cart_size = Integer.toString(size);

        if(size<=3 && size>0){
//            itemNames.add(items.get(0));
            item1.setText(items.get(0));
            if(size>1){
//                itemNames.add(items.get(1));
                item2.setText(items.get(1));
                if (size>2){
//                    itemNames.add(items.get(2));
                    item3.setText(items.get(2));
                    if (size>3){
                        item4.setText(items.get(3));
                    }
                }
            }
        }

//        msg1 = items.get(0);
//        msg2 = items.get(1);
//        msg3 = items.get(2);
//
//        item1.setText(msg1);
//        item2.setText(msg2);
//        item3.setText(msg3);

//        continue_btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//            }
//        });




    }

    public void addToCart(View view){
        DBHelper dbHelper = new DBHelper(this);
//        String val3=null;
        item_name1 = item_name2=item_name3=item_name4="item";
        item_quantity1=item_quantity2=item_quantity3=item_quantity4="1";
        item_size1=item_size2=item_size3=item_size4="small";



        if(size<=3 && size>0){
            item_name1 = item1.getText().toString();
            item_quantity1 = quantity1.getText().toString();
            item_size1 = size1.getText().toString();
            ID1 = dbHelper.addCartRowTableInfo(item_name1,item_quantity1,item_size1);
            if(size>1){
                item_name2 = item2.getText().toString();
                item_quantity2 = quantity2.getText().toString();
                item_size2 = size2.getText().toString();
                ID2 = dbHelper.addCartRowTableInfo(item_name2,item_quantity2,item_size2);
                if (size>2){
                    item_name3 = item3.getText().toString();
                    item_quantity3 = quantity3.getText().toString();
                    item_size3 = size3.getText().toString();
                    ID3 = dbHelper.addCartRowTableInfo(item_name3,item_quantity3,item_size3);
                    if (size>3){
                        item_name4 = item4.getText().toString();
                        item_quantity4 = quantity4.getText().toString();
                        item_size4 = size4.getText().toString();
                        ID4 = dbHelper.addCartRowTableInfo(item_name4,item_quantity4,item_size4);
                    }
                }
            }
        }

//        String val = dbHelper.addCartTableInfo(item_name1,item_name2,item_name3,item_name4,item_quantity1,item_quantity2,item_quantity3,item_quantity4,item_size1,item_size2,item_size3,item_size4);





        Intent i1 = new Intent(FoodCart.this,OrderDetails.class);
//        i1.putExtra("cart_id",val);
        i1.putExtra("cart_size",cart_size);
        i1.putExtra("ID1",ID1);
        i1.putExtra("ID2",ID2);
        i1.putExtra("ID3",ID3);
        i1.putExtra("ID4",ID4);
//        if (size<=3 && size>0){
//            i1.putExtra("ID1",val1);
//            if (size>1){
//                i1.putExtra("ID2",val2);
//                if (size>2){
//                    i1.putExtra("ID3",val3);
//                }
//            }
//        }
//        //Filling items_and_quantities
//        items_and_quantities.put(item1.getText().toString(),quantity1.getText().toString());
//        items_and_quantities.put(item2.getText().toString(),quantity2.getText().toString());
//        items_and_quantities.put(item3.getText().toString(),quantity3.getText().toString());
//        //Fillin items_and_sizes
//        items_and_sizes.put(item1.getText().toString(),size1.getText().toString());
//        items_and_sizes.put(item2.getText().toString(),size2.getText().toString());
//        items_and_sizes.put(item3.getText().toString(),size3.getText().toString());
        //Adding extra to intent
//        i1.putExtra("items_and_quantities",(HashMap<String,String>)items_and_quantities);
//        i1.putExtra("items_and_sizes",(HashMap<String,String>)items_and_sizes);


        if (ID1!=null || ID2!=null || ID3!=null || ID4!=null){
            Toast.makeText(this, "Data successfully inserted "+ID1, Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Data Not inserted!", Toast.LENGTH_SHORT).show();
        }

        startActivity(i1);
    }

//    private String generateCartsIDs(List arrayList) {
//
//        boolean ans = arrayList.isEmpty();
//        int nextId;
//        if (ans==true){
//            nextId = 1;
//        }
//        else {
//            nextId = arrayList.size();
//            nextId++;
//        }
//
//        String cartId;
////        int nextId = arrayList.size();
//
//        cartId = "C000" + nextId;
//        if (arrayList.contains(cartId)) {
//            nextId++;
//            cartId = "C000" + nextId;
//        }
//        return cartId;
//    }
}