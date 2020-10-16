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
import com.example.thedeliverer.Database.OrderCommonVariables;

public class OrderDetails extends AppCompatActivity {
    //Variables
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
    String quantity1,quantity2, quantity3,quantity4;
    String size1,size2,size3,size4;
    EditText special_instructions_txt;
    Button edit_btn,delete_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        //Referencing to resources in OrderDetails layout with correspoding ID
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
        //Initializing buttons
        Button continue_btn = findViewById(R.id.continue_button);
        edit_btn = findViewById(R.id.edit_btn);
        edit_btn.setVisibility(View.INVISIBLE);
        delete_btn = findViewById(R.id.delete_btn);
        delete_btn.setVisibility(View.INVISIBLE);

        //Initializing second table values
        item_name = findViewById(R.id.item_name);
        item_quantity = findViewById(R.id.item_quantity);
        item_size = findViewById(R.id.item_size);

        //String array
        item1 = item2 = item3 = item4 = "item";
        ID1 = null;
        ID2 = null;
        ID3 = null;
        ID4 = null;
        quantity1 = quantity2 = quantity3 = quantity4 = "1";
        size1 = size2 = size3 = size4 = "small";

        id1 = id2=id3 = id4 = 0;



        Intent intent = getIntent();
        size = getIntent().getStringExtra("cart_size");
        ID1 = getIntent().getStringExtra("ID1");
        ID2 = getIntent().getStringExtra("ID2");
        ID3 = getIntent().getStringExtra("ID3");
        ID4 = getIntent().getStringExtra("ID4");

        cart_size = Integer.parseInt(size);

        //Initializing dbHelperOrder
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        if (cart_size>0){

            id1 = Integer.parseInt(ID1);
            item_ID = id1;

            //Retrieving data from the cart row table with cart row ID
            Cursor r1 = dbHelperOrder.getCartRowData(id1);

            if (r1!=null){
                r1.moveToFirst();
                item1 = r1.getString(r1.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                quantity1 = r1.getString(r1.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                size1 = r1.getString(r1.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));
            }


            if (!r1.isClosed())  {
                r1.close();
            }

            //Setting up edit texts in OrderDetails with values retrieved by cart row table
            food_item1.setText(item1);
            food_quantity1.setText(quantity1);
            food_quantity1.setEnabled(false);
            food_size1.setText(size1);
            food_size1.setEnabled(false);

            if (cart_size>1){
                id2 = Integer.parseInt(ID2);

                //Retrieving data from the cart row table with cart row ID
                Cursor r2 = dbHelperOrder.getCartRowData(id2);
                r2.moveToFirst();
                item2 = r2.getString(r2.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                quantity2 = r2.getString(r2.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                size2 = r2.getString(r2.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));

                if (!r2.isClosed())  {
                    r2.close();
                }

                //Setting up edit texts in OrderDetails with values retrieved by cart row table
                food_item2.setText(item2);
                food_quantity2.setText(quantity2);
                food_quantity2.setEnabled(false);
                food_size2.setText(size2);
                food_size2.setEnabled(false);

                if (cart_size>2){
                    id3 = Integer.parseInt(ID3);

                    //Retrieving data from the cart row table with cart row ID
                    Cursor r3 = dbHelperOrder.getCartRowData(id3);
                    r3.moveToFirst();
                    item3 = r3.getString(r3.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                    quantity3 = r3.getString(r3.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                    size3 = r3.getString(r3.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));

                    if (!r3.isClosed())  {
                        r3.close();
                    }

                    //Setting up edit texts in OrderDetails with values retrieved by cart row table
                    food_item3.setText(item3);
                    food_quantity3.setText(quantity3);
                    food_quantity3.setEnabled(false);
                    food_size3.setText(size3);
                    food_size3.setEnabled(false);

                    if (cart_size>3){
                        id4 = Integer.parseInt(ID4);

                        //Retrieving data from the cart row table with cart row ID
                        Cursor r4 = dbHelperOrder.getCartRowData(id4);
                        r4.moveToFirst();
                        item4 = r4.getString(r4.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                        quantity4 = r4.getString(r4.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                        size4 = r4.getString(r4.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));

                        if (!r4.isClosed())  {
                            r4.close();
                        }

                        //Setting up edit texts in OrderDetails with values retrieved by cart row table
                        food_item4.setText(item4);
                        food_quantity4.setText(quantity4);
                        food_quantity4.setEnabled(false);
                        food_size4.setText(size4);
                        food_size4.setEnabled(false);
                    }
                }
            }
        }
    }

    //Setting up second table with values obtained from first table
    //First row click method
    public void setRowDetails1(View view){
        item_ID = id1;
        item_name.setText(food_item1.getText().toString());
        item_quantity.setText(food_quantity1.getText().toString());
        item_size.setText(food_size1.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    //Second row click method
    public void setRowDetails2(View view){
        item_ID = id2;
        item_name.setText(food_item2.getText().toString());
        item_quantity.setText(food_quantity2.getText().toString());
        item_size.setText(food_size2.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    //Third row click method
    public void setRowDetails3(View view){
        item_ID = id3;
        item_name.setText(food_item3.getText().toString());
        item_quantity.setText(food_quantity3.getText().toString());
        item_size.setText(food_size3.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    //Fourth row click method
    public void setRowDetails4(View view){
        item_ID = id4;
        item_name.setText(food_item4.getText().toString());
        item_quantity.setText(food_quantity4.getText().toString());
        item_size.setText(food_size4.getText().toString());
        edit_btn.setVisibility(View.VISIBLE);
        delete_btn.setVisibility(View.VISIBLE);
    }

    //Continue button method
    public void sendDataForConfirmation(View view){
        //Initializing dbHelperOrder
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        item_name1 = item_name2=item_name3=item_name4="item";
        item_quantity1=item_quantity2=item_quantity3=item_quantity4="1";
        item_size1=item_size2=item_size3=item_size4="small";

        //Assign variables with user entered values in edit texts
        if(cart_size>0){
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

        //Insert data into cart table
        carts_id = dbHelperOrder.addCartTableInfo(item_name1,item_name2,item_name3,item_name4,item_quantity1,item_quantity2,item_quantity3,item_quantity4,item_size1,item_size2,item_size3,item_size4);

        //Navigate to OrderConfirmation.class
        Intent i1 = new Intent(OrderDetails.this,OrderConfirmation.class);
        i1.putExtra("special_inst",special_instructions_txt.getText().toString());
        i1.putExtra("cartId",carts_id);
        i1.putExtra("cart_size",size);

        //Checking whether data got inserted successfully or not
        if (carts_id!=null){
            Toast.makeText(this, "Data successfully inserted "+carts_id, Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Data Not inserted!", Toast.LENGTH_SHORT).show();
        }
        startActivity(i1);

    }

    //Delete button method
    public void deleteData(View view){
        //Initializing dbhelperorder
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        item_name1 = item_name2=item_name3=item_name4="item";
        item_quantity1=item_quantity2=item_quantity3=item_quantity4="1";
        item_size1=item_size2=item_size3=item_size4="small";

        //Delete cart row table with a given ID
        dbHelperOrder.deleteCartRowInfo(item_ID);
        //After deleting cart row this, navigates to the same class
        //Thus creating cart row tables for the existing rows on the first table of OrderDetails layout

            if (item_ID == id1){
                if(cart_size>0){
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
                if(cart_size>0){
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
                if(cart_size>0){
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
                if(cart_size>0){
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

            //Navigating to the same page
        //Thus with the same number of intent extras with updated values
        Intent i1 = new Intent(OrderDetails.this,OrderDetails.class);
        i1.putExtra("cart_size",size);
        i1.putExtra("ID1",ID1);
        i1.putExtra("ID2",ID2);
        i1.putExtra("ID3",ID3);
        i1.putExtra("ID4",ID4);

        Toast.makeText(this, item_name.getText().toString() + " deleted Successfully", Toast.LENGTH_SHORT).show();

        startActivity(i1);

    }

    //Update button method
    public void updateData(View view){
        //initializing dbHelperOrder
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        item_name1 = item_name2=item_name3=item_name4="item";
        item_quantity1=item_quantity2=item_quantity3=item_quantity4="1";
        item_size1=item_size2=item_size3=item_size4="small";

        //Update cart row table
        int count = dbHelperOrder.updateCartRowInfo(item_ID,item_name.getText().toString(),item_quantity.getText().toString(),item_size.getText().toString());
        //After updating cart row this, navigates to the same class
        //Thus insert cart row tables again for the existing rows on the first table of OrderDetails layout
        if (cart_size>0){

            Cursor r1 = dbHelperOrder.getCartRowData(id1);

            if (r1!=null){
                r1.moveToFirst();
                item1 = r1.getString(r1.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                quantity1 = r1.getString(r1.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                size1 = r1.getString(r1.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));
            }


            if (!r1.isClosed())  {
                r1.close();
            }

            ID1 = dbHelperOrder.addCartRowTableInfo(item1,quantity1,size1);


            if (cart_size>1){

                Cursor r2 = dbHelperOrder.getCartRowData(id2);
                r2.moveToFirst();
                item2 = r2.getString(r2.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                quantity2 = r2.getString(r2.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                size2 = r2.getString(r2.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));

                if (!r2.isClosed())  {
                    r2.close();
                }
                ID2 = dbHelperOrder.addCartRowTableInfo(item2,quantity2,size2);


                if (cart_size>2){
//                    id3 = Integer.parseInt(ID3);

                    Cursor r3 = dbHelperOrder.getCartRowData(id3);
                    r3.moveToFirst();
                    item3 = r3.getString(r3.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                    quantity3 = r3.getString(r3.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                    size3 = r3.getString(r3.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));

                    if (!r3.isClosed())  {
                        r3.close();
                    }
                    ID3 = dbHelperOrder.addCartRowTableInfo(item3,quantity3,size3);


                    if (cart_size>3){
                        id4 = Integer.parseInt(ID4);

                        Cursor r4 = dbHelperOrder.getCartRowData(id4);
                        r4.moveToFirst();
                        item4 = r4.getString(r4.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM));
                        quantity4 = r4.getString(r4.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY));
                        size4 = r4.getString(r4.getColumnIndex(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE));

                        if (!r4.isClosed())  {
                            r4.close();
                        }
                        ID4 = dbHelperOrder.addCartRowTableInfo(item4,quantity4,size4);

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

        //Checking whether data got updated successfully
        if (count>0){
            Toast.makeText(this, "Data updates successfully", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Data did not update!", Toast.LENGTH_SHORT).show();
        }

        startActivity(i2);

    }


}