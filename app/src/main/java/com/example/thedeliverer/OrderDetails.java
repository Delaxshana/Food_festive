package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelperOrder;
import com.example.thedeliverer.Database.UsersMaster;

import java.util.Map;

public class OrderDetails extends AppCompatActivity {
    TextView food_item1,food_item2,food_item3,food_item4;
    EditText food_quantity1,food_quantity2,food_quantity3,food_quantity4;
    EditText food_size1,food_size2,food_size3,food_size4;
    EditText item_name,item_quantity,item_size;
    String item_name1,item_name2,item_name3,item_name4,item_quantity1,item_quantity2,item_quantity3,item_quantity4,item_size1,item_size2,item_size3,item_size4;
    String item1,item2,item3,item4;
    int id1,id2,id3,id4;
    int item_ID;
    String cartId,carts_id,size;
    int cart_ID,cart_size;
    String ID1,ID2,ID3,ID4,ID5,ID6;
    String items1,items2,items3;
    String quantities1,quantities2,quantities3;
    String sizes1;
    String quantity1,quantity2, quantity3,quantity4;
    String size1,size2,size3,size4;
    Map<String,String> items_quantities;
    Map<String,String> items_sizes;
    Map<String,String> items_names;
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
//        items_quantities = new HashMap<String, String>();
//        items_sizes = new HashMap<String, String>();
//        items_names = new HashMap<String, String>();
        //String array
        item1 = item2 = item3 = item4 = "item";
        ID1 = null;
        ID2 = null;
        ID3 = null;
        ID4 = null;
        quantity1 = quantity2 = quantity3 = quantity4 = "1";
        size1 = size2 = size3 = size4 = "small";

        id1 = id2=id3 = id4 = 0;

//        String items[] = {};
//        String quantities[] = {};
        //int i =0;

        Button continue_btn = findViewById(R.id.continue_button);
        edit_btn = findViewById(R.id.edit_btn);
        edit_btn.setVisibility(View.INVISIBLE);
        delete_btn = findViewById(R.id.delete_btn);
        delete_btn.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
//        carts_id = getIntent().getStringExtra("cart_id");
        size = getIntent().getStringExtra("cart_size");
        ID1 = getIntent().getStringExtra("ID1");
        ID2 = getIntent().getStringExtra("ID2");
        ID3 = getIntent().getStringExtra("ID3");
        ID4 = getIntent().getStringExtra("ID4");



        cart_size = Integer.parseInt(size);
//        cart_ID = Integer.parseInt(carts_id);
//        int numOfextras=getIntent().getExtras().size();
////
//        if(numOfextras<=3 && numOfextras>0){
//            ID1 = intent.getStringExtra("ID1");
////            Toast.makeText(getApplication(),"The total is "+ID1+" ",Toast.LENGTH_SHORT).show();
//            if(numOfextras>1){
//                ID2 = intent.getStringExtra("ID2");
////                Toast.makeText(getApplication(),"The total is "+ID2+" ",Toast.LENGTH_SHORT).show();
//                if (numOfextras>2){
//                    ID3 = intent.getStringExtra("ID3");
//                    Toast.makeText(getApplication(),"The total is "+ID3+" ",Toast.LENGTH_SHORT).show();
//                }
//            }
//        }



        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

//        cartId = dbHelper.readAllcartsInfo("cart_ID");
//        item1 = dbHelper.readAllcartsInfo("item1");
//        item2 = dbHelper.readAllcartsInfo("item2");
//        item3 = dbHelper.readAllcartsInfo("item3");
//        item4 = dbHelper.readAllcartsInfo("item4");
//        quantity1 = dbHelper.readAllcartsInfo("quantity1");
//        quantity2 = dbHelper.readAllcartsInfo("quantity2");
//        quantity3 = dbHelper.readAllcartsInfo("quantity3");
//        size1 = dbHelper.readAllcartsInfo("size1");
//        size2 = dbHelper.readAllcartsInfo("size2");
//        size3 = dbHelper.readAllcartsInfo("size3");

//        Cursor rs = dbHelper.getCartData(cart_ID);
//        rs.moveToFirst();

        if (cart_size>0){

            id1 = Integer.parseInt(ID1);
            item_ID = id1;

            Cursor r1 = dbHelperOrder.getCartRowData(id1);

            if (r1!=null){
                r1.moveToFirst();
                item1 = r1.getString(r1.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                quantity1 = r1.getString(r1.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                size1 = r1.getString(r1.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));
            }


            if (!r1.isClosed())  {
                r1.close();
            }

//            item1 = dbHelper.readAllCartRowInfo("item_name");
//            quantity1 = dbHelper.readAllCartRowInfo("item_quantity");
//            size1 = dbHelper.readAllCartRowInfo("item_size");

            food_item1.setText(item1);
            food_quantity1.setText(quantity1);
            food_quantity1.setEnabled(false);
            food_size1.setText(size1);
            food_size1.setEnabled(false);

            if (cart_size>1){
                id2 = Integer.parseInt(ID2);

                Cursor r2 = dbHelperOrder.getCartRowData(id2);
                r2.moveToFirst();
                item2 = r2.getString(r2.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                quantity2 = r2.getString(r2.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                size2 = r2.getString(r2.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));

                if (!r2.isClosed())  {
                    r2.close();
                }

//                item2 = dbHelper.readAllCartRowInfo("item_name");
//                quantity2 = dbHelper.readAllCartRowInfo("item_quantity");
//                size2 = dbHelper.readAllCartRowInfo("item_size");

                food_item2.setText(item2);
                food_quantity2.setText(quantity2);
                food_quantity2.setEnabled(false);
                food_size2.setText(size2);
                food_size2.setEnabled(false);

                if (cart_size>2){
                    id3 = Integer.parseInt(ID3);

                    Cursor r3 = dbHelperOrder.getCartRowData(id3);
                    r3.moveToFirst();
                    item3 = r3.getString(r3.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                    quantity3 = r3.getString(r3.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                    size3 = r3.getString(r3.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));

                    if (!r3.isClosed())  {
                        r3.close();
                    }

//                    item3 = dbHelper.readAllCartRowInfo("item_name");
//                    quantity3 = dbHelper.readAllCartRowInfo("item_quantity");
//                    size3 = dbHelper.readAllCartRowInfo("item_size");

                    food_item3.setText(item3);
                    food_quantity3.setText(quantity3);
                    food_quantity3.setEnabled(false);
                    food_size3.setText(size3);
                    food_size3.setEnabled(false);

                    if (cart_size>3){
                        id4 = Integer.parseInt(ID4);

                        Cursor r4 = dbHelperOrder.getCartRowData(id4);
                        r4.moveToFirst();
                        item4 = r4.getString(r4.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                        quantity4 = r4.getString(r4.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                        size4 = r4.getString(r4.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));

                        if (!r4.isClosed())  {
                            r4.close();
                        }
//
//                        item4 = dbHelper.readAllCartRowInfo("item_name");
//                        quantity4 = dbHelper.readAllCartRowInfo("item_quantity");
//                        size4 = dbHelper.readAllCartRowInfo("item_size");

                        food_item4.setText(item4);
                        food_quantity4.setText(quantity4);
                        food_quantity4.setEnabled(false);
                        food_size4.setText(size4);
                        food_size4.setEnabled(false);
                    }
                }
            }
        }











//        if (!rs.isClosed())  {
//            rs.close();
//        }
//        items_quantities= dbHelper.readAllcartsInfoQ("items_and_quantities");
//        items_sizes = dbHelper.readAllcartsInfoSize("items_and_sizes");


//        items_Ids = dbHelper.readAllcartsInfo("item_ids");
//        items_quantities = (HashMap<String, String>) intent.getSerializableExtra("items_and_quantities");
//        items_sizes = (HashMap<String, String>)intent.getSerializableExtra("items_and_sizes");

//        for (String key:items_names.keySet()){
//            if (ID1 == null){
//                ID1 = key;
//                item1 = items_names.get(key);
//                continue;
//            }
//
//            if(ID1!=null && ID2 == null){
//                ID2 = key;
//                item2 = items_names.get(key);
//                continue;
//            }
//
//            if (ID1 != null && ID2!=null && ID3==null){
//                ID3 = key;
//                item3 = items_names.get(key);
//                break;
//            }
////            quantities[i] = items_quantities.get(key);
//        }

//        for (String key:items_quantities.keySet()){
//
//                ID4 = key;
//                if (ID4 == ID1){
//                    quantity1 = items_quantities.get(key);
//                }
//                if (ID4 == ID2){
//                    quantity2 = items_quantities.get(key);
//                }
//                if (ID4 == ID3){
//                    quantity3 = items_quantities.get(key);
//                }
//
//        }
//
//        for (String key:items_sizes.keySet()){
//
//            ID4 = key;
//            if (ID4 == ID1){
//                size1 = items_sizes.get(key);
//            }
//            if (ID4 == ID2){
//                size2 = items_sizes.get(key);
//            }
//            if (ID4 == ID3){
//                size3 = items_sizes.get(key);
//            }
//
//        }

//        for (String key:items_quantities.keySet()){
//            if (item1 == null){
//                item1 = key;
//                quantity1 = items_quantities.get(key);
//                continue;
//            }
//
//            if(item1!=null && item2 == null){
//                item2 = key;
//                quantity2 = items_quantities.get(key);
//                continue;
//            }
//
//            if (item1 != null && item2!=null && item3==null){
//                item3 = key;
//                quantity3 = items_quantities.get(key);
//                break;
//            }
////            quantities[i] = items_quantities.get(key);
//        }

//        for (String key:items_Ids.keySet()){
//            if (item1 == null){
//                quantity1 = key;
//                item1 = items_Ids.get(key);
//                continue;
//            }
//
//            if(item1!=null && item2 == null){
//                quantity2 = key;
//                item2 = items_Ids.get(key);
//                continue;
//            }
//
//            if (item1 != null && item2!=null && item3==null){
//                quantity3 = key;
//                item3 = items_Ids.get(key);
//                break;
//            }
////            quantities[i] = items_quantities.get(key);
//        }

//        for (String key:items_sizes.keySet()){
//            if (items1 == null){
//                items1 = key;
//                size1 = items_sizes.get(key);
//                continue;
//            }
//
//            if(items1!=null && items2 == null){
//                items2 = key;
//                size2 = items_sizes.get(key);
//                continue;
//            }
//
//            if (items1 != null && items2!=null && items3==null){
//                items3 = key;
//                size3 = items_sizes.get(key);
//                break;
//            }
////            quantities[i] = items_quantities.get(key);
//        }


//        food_item1.setEnabled(false);

//        food_item2.setEnabled(false);


//        food_item3.setEnabled(false);






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





//        continue_btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent i1 = new Intent(OrderDetails.this,OrderConfirmation.class);
//                i1.putExtra("special_inst",special_instructions_txt.getText().toString());
//                i1.putExtra("cartId",carts_id);
//                startActivity(i1);
//            }
//        });
    }

    public void setRowDetails1(View view){
        item_ID = id1;
        item_name.setText(food_item1.getText().toString());
        item_quantity.setText(food_quantity1.getText().toString());
        item_size.setText(food_size1.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    public void setRowDetails2(View view){
        item_ID = id2;
        item_name.setText(food_item2.getText().toString());
        item_quantity.setText(food_quantity2.getText().toString());
        item_size.setText(food_size2.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    public void setRowDetails3(View view){
        item_ID = id3;
        item_name.setText(food_item3.getText().toString());
        item_quantity.setText(food_quantity3.getText().toString());
        item_size.setText(food_size3.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    public void setRowDetails4(View view){
        item_ID = id4;
        item_name.setText(food_item4.getText().toString());
        item_quantity.setText(food_quantity4.getText().toString());
        item_size.setText(food_size4.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    public void sendDataForConfirmation(View view){
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        item_name1 = item_name2=item_name3=item_name4="item";
        item_quantity1=item_quantity2=item_quantity3=item_quantity4="1";
        item_size1=item_size2=item_size3=item_size4="small";



        if(cart_size<=3 && cart_size>0){
            item_name1 = food_item1.getText().toString();
            item_quantity1 = food_quantity1.getText().toString();
            item_size1 = food_size1.getText().toString();
            if(cart_size>1){
                item_name2 = food_item2.getText().toString();
                item_quantity2 = food_quantity2.getText().toString();
                item_size2 = food_size2.getText().toString();

                if (cart_size>2){
                    item_name3 = food_item3.getText().toString();
                    item_quantity3 = food_quantity3.getText().toString();
                    item_size3 = food_size3.getText().toString();

                    if (cart_size>3){
                        item_name4 = food_item4.getText().toString();
                        item_quantity4 = food_quantity4.getText().toString();
                        item_size4 = food_size4.getText().toString();

                    }
                }
            }
        }

        carts_id = dbHelperOrder.addCartTableInfo(item_name1,item_name2,item_name3,item_name4,item_quantity1,item_quantity2,item_quantity3,item_quantity4,item_size1,item_size2,item_size3,item_size4);

        Intent i1 = new Intent(OrderDetails.this,OrderConfirmation.class);
        i1.putExtra("special_inst",special_instructions_txt.getText().toString());
        i1.putExtra("cartId",carts_id);

        if (carts_id!=null){
            Toast.makeText(this, "Data successfully inserted "+carts_id, Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Data Not inserted!", Toast.LENGTH_SHORT).show();
        }
        startActivity(i1);

    }

    public void deleteData(View view){
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        item_name1 = item_name2=item_name3=item_name4="item";
        item_quantity1=item_quantity2=item_quantity3=item_quantity4="1";
        item_size1=item_size2=item_size3=item_size4="small";

        dbHelperOrder.deleteCartInfo(item_ID);

            if (item_ID == id1){
                if(cart_size<=3 && cart_size>0){
                    if(cart_size>1){
                        item_name2 = food_item2.getText().toString();
                        item_quantity2 = food_quantity2.getText().toString();
                        item_size2 = food_size2.getText().toString();
                        ID1 = dbHelperOrder.addCartRowTableInfo(item_name2,item_quantity2,item_size2);

                        if (cart_size>2){
                            item_name3 = food_item3.getText().toString();
                            item_quantity3 = food_quantity3.getText().toString();
                            item_size3 = food_size3.getText().toString();

                            ID2 = dbHelperOrder.addCartRowTableInfo(item_name3,item_quantity3,item_size3);

                            if (cart_size>3){
                                item_name4 = food_item4.getText().toString();
                                item_quantity4 = food_quantity4.getText().toString();
                                item_size4 = food_size4.getText().toString();

                                ID3 = dbHelperOrder.addCartRowTableInfo(item_name4,item_quantity4,item_size4);

                            }
                        }
                    }
                }
                ID4 = null;
                cart_size = cart_size - 1;
            }

            else if (item_ID == id2){
                if(cart_size<=3 && cart_size>0){
                    item_name1 = food_item1.getText().toString();
                    item_quantity1 = food_quantity1.getText().toString();
                    item_size1 = food_size1.getText().toString();
                    ID1 = dbHelperOrder.addCartRowTableInfo(item_name1,item_quantity1,item_size1);
                    if(cart_size>1){

                        if (cart_size>2){
                            item_name3 = food_item3.getText().toString();
                            item_quantity3 = food_quantity3.getText().toString();
                            item_size3 = food_size3.getText().toString();

                            ID2 = dbHelperOrder.addCartRowTableInfo(item_name3,item_quantity3,item_size3);

                            if (cart_size>3){
                                item_name4 = food_item4.getText().toString();
                                item_quantity4 = food_quantity4.getText().toString();
                                item_size4 = food_size4.getText().toString();

                                ID3 = dbHelperOrder.addCartRowTableInfo(item_name4,item_quantity4,item_size4);

                            }
                        }
                    }
                }
                ID4 = null;
                cart_size = cart_size - 1;
            }

            else if (item_ID == id3){
                if(cart_size<=3 && cart_size>0){
                    item_name1 = food_item1.getText().toString();
                    item_quantity1 = food_quantity1.getText().toString();
                    item_size1 = food_size1.getText().toString();
                    ID1 = dbHelperOrder.addCartRowTableInfo(item_name1,item_quantity1,item_size1);
                    if(cart_size>1){
                        item_name2 = food_item2.getText().toString();
                        item_quantity2 = food_quantity2.getText().toString();
                        item_size2 = food_size2.getText().toString();

                        ID2 = dbHelperOrder.addCartRowTableInfo(item_name2,item_quantity2,item_size2);
                        if (cart_size>2){

                            if (cart_size>3){
                                item_name4 = food_item4.getText().toString();
                                item_quantity4 = food_quantity4.getText().toString();
                                item_size4 = food_size4.getText().toString();

                                ID3 = dbHelperOrder.addCartRowTableInfo(item_name4,item_quantity4,item_size4);

                            }
                        }
                    }
                }
                ID4 = null;
                cart_size = cart_size - 1;

            } else if (item_ID == id4){
                if(cart_size<=3 && cart_size>0){
                    item_name1 = food_item1.getText().toString();
                    item_quantity1 = food_quantity1.getText().toString();
                    item_size1 = food_size1.getText().toString();
                    ID1 = dbHelperOrder.addCartRowTableInfo(item_name1,item_quantity1,item_size1);
                    if(cart_size>1){
                        item_name2 = food_item2.getText().toString();
                        item_quantity2 = food_quantity2.getText().toString();
                        item_size2 = food_size2.getText().toString();

                        ID2 = dbHelperOrder.addCartRowTableInfo(item_name2,item_quantity2,item_size2);
                        if (cart_size>2){
                            item_name3 = food_item3.getText().toString();
                            item_quantity3 = food_quantity3.getText().toString();
                            item_size3 = food_size3.getText().toString();

                            ID3 = dbHelperOrder.addCartRowTableInfo(item_name3,item_quantity3,item_size3);

                            if (cart_size>3){


                            }
                        }
                    }
                }
                ID4 = null;
                cart_size = cart_size - 1;
            }

            size = Integer.toString(cart_size);

        Intent i1 = new Intent(OrderDetails.this,OrderDetails.class);
        i1.putExtra("cart_size",size);
        i1.putExtra("ID1",ID1);
        i1.putExtra("ID2",ID2);
        i1.putExtra("ID3",ID3);
        i1.putExtra("ID4",ID4);

        Toast.makeText(this, item_name.getText().toString() + " deleted Successfully", Toast.LENGTH_SHORT).show();

        startActivity(i1);

    }

    public void updateData(View view){
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        item_name1 = item_name2=item_name3=item_name4="item";
        item_quantity1=item_quantity2=item_quantity3=item_quantity4="1";
        item_size1=item_size2=item_size3=item_size4="small";

        dbHelperOrder.updateCartInfo(item_ID,item_name.getText().toString(),item_quantity.getText().toString(),item_size.getText().toString());

        Toast.makeText(this, "Data updates successfully", Toast.LENGTH_SHORT).show();
        if (cart_size>0){

            Cursor r1 = dbHelperOrder.getCartRowData(id1);

            if (r1!=null){
                r1.moveToFirst();
                item1 = r1.getString(r1.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                quantity1 = r1.getString(r1.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                size1 = r1.getString(r1.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));
            }


            if (!r1.isClosed())  {
                r1.close();
            }

            ID1 = dbHelperOrder.addCartRowTableInfo(item1,quantity1,size1);

//            item1 = dbHelper.readAllCartRowInfo("item_name");
//            quantity1 = dbHelper.readAllCartRowInfo("item_quantity");
//            size1 = dbHelper.readAllCartRowInfo("item_size");

            if (cart_size>1){

                Cursor r2 = dbHelperOrder.getCartRowData(id2);
                r2.moveToFirst();
                item2 = r2.getString(r2.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                quantity2 = r2.getString(r2.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                size2 = r2.getString(r2.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));

                if (!r2.isClosed())  {
                    r2.close();
                }
                ID2 = dbHelperOrder.addCartRowTableInfo(item2,quantity2,size2);

//                item2 = dbHelper.readAllCartRowInfo("item_name");
//                quantity2 = dbHelper.readAllCartRowInfo("item_quantity");
//                size2 = dbHelper.readAllCartRowInfo("item_size");

                if (cart_size>2){
//                    id3 = Integer.parseInt(ID3);

                    Cursor r3 = dbHelperOrder.getCartRowData(id3);
                    r3.moveToFirst();
                    item3 = r3.getString(r3.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                    quantity3 = r3.getString(r3.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                    size3 = r3.getString(r3.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));

                    if (!r3.isClosed())  {
                        r3.close();
                    }
                    ID3 = dbHelperOrder.addCartRowTableInfo(item3,quantity3,size3);

//                    item3 = dbHelper.readAllCartRowInfo("item_name");
//                    quantity3 = dbHelper.readAllCartRowInfo("item_quantity");
//                    size3 = dbHelper.readAllCartRowInfo("item_size");

                    if (cart_size>3){
                        id4 = Integer.parseInt(ID4);

                        Cursor r4 = dbHelperOrder.getCartRowData(id4);
                        r4.moveToFirst();
                        item4 = r4.getString(r4.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
                        quantity4 = r4.getString(r4.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
                        size4 = r4.getString(r4.getColumnIndex(UsersMaster.Cart_row.COLUMN_NAME_SIZE));

                        if (!r4.isClosed())  {
                            r4.close();
                        }
                        ID4 = dbHelperOrder.addCartRowTableInfo(item4,quantity4,size4);
//
//                        item4 = dbHelper.readAllCartRowInfo("item_name");
//                        quantity4 = dbHelper.readAllCartRowInfo("item_quantity");
//                        size4 = dbHelper.readAllCartRowInfo("item_size");
                    }
                }
            }
        }
        Intent i2 = new Intent(OrderDetails.this,OrderDetails.class);
        i2.putExtra("cart_size",size);
        i2.putExtra("ID1",ID1);
        i2.putExtra("ID2",ID2);
        i2.putExtra("ID3",ID3);
        i2.putExtra("ID4",ID4);
//        if (val>0){
            Toast.makeText(this, "Data updates successfully", Toast.LENGTH_SHORT).show();
//        } else{
//            Toast.makeText(this, "Data did not update!", Toast.LENGTH_SHORT).show();
//        }

        startActivity(i2);

    }



//    public void readCartInfo(View view){
//
//
//        Toast.makeText(this,unames.toString(), Toast.LENGTH_SHORT).show();
//    }


}