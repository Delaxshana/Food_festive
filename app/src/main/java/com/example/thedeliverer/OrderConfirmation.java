package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelperOrder;
import com.example.thedeliverer.Database.OrderCommonVariables;

public class OrderConfirmation extends AppCompatActivity {
    //Variables
    RadioButton pickup_btn,delivery_btn;
    EditText date_input, time_input;
    String special_instructions_msg,cartID,cart_size;
    String orderID;
    int total,quantity1,quantity2,quantity3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        //Initializing all the input values
        pickup_btn = findViewById(R.id.pickup_btn);
        delivery_btn = findViewById(R.id.delivery_btn);
        date_input = findViewById(R.id.date_input);
        time_input = findViewById(R.id.time_input);

        //initializing quantity variables
        quantity1 = quantity2 = quantity3 = 0;

        //Get intent from Order Details class
        Intent intent = getIntent();
        special_instructions_msg = getIntent().getStringExtra("special_inst");
        cartID = getIntent().getStringExtra("cartId");
        cart_size = getIntent().getStringExtra("cart_size");

        int cartSize = Integer.parseInt(cart_size);

        int cart_ID = Integer.parseInt(cartID);

        //Initializing dbHelperOrder
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        Cursor rs = dbHelperOrder.getCartData(cart_ID);
        rs.moveToFirst();

        //Obtaining quantities of all the food items in the cart
        if (cartSize>0){
            String q1 = rs.getString(rs.getColumnIndex(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY1));
            quantity1 = Integer.parseInt(q1);
            if (cartSize>1){
                String q2 = rs.getString(rs.getColumnIndex(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY2));
                quantity2 = Integer.parseInt(q2);
                if (cartSize>2){
                    String q3 = rs.getString(rs.getColumnIndex(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY3));
                    quantity3 = Integer.parseInt(q3);
                }
            }
        }


        if (!rs.isClosed())  {
            rs.close();
        }


    }

    //Confirm Order button method
    public void sendData(View view){

        //Find the total of quantities using addQuantities method
        total = addQuantities(quantity1,quantity2,quantity3);

        //Checking whether pickup button is clicked
        boolean checked = pickup_btn.isChecked();

        //Initializing dbHelperOrder
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        //Insertng data to Order table
        orderID = dbHelperOrder.addOrderTableInfo(cartID,special_instructions_msg,date_input.getText().toString(),time_input.getText().toString());

        //Navigating to payment component based on order type
        if (checked == true){
            Intent i1 = new Intent(OrderConfirmation.this,OrderConfirmation.class);
            i1.putExtra("total_items",total);
            i1.putExtra("orderID",orderID);
            i1.putExtra("cart_size",cart_size);

            if (orderID!=null){
                Toast.makeText(this, "Data successfully inserted, "+total+" items to be collected", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Data Not inserted!", Toast.LENGTH_SHORT).show();
            }

            startActivity(i1);
        }
        else {
            Intent i2 = new Intent(OrderConfirmation.this,OrderConfirmation.class);
            i2.putExtra("total_items",total);
            i2.putExtra("orderID",orderID);
            i2.putExtra("cart_size",cart_size);

            if (orderID!=null){
                Toast.makeText(this, "Data successfully inserted, "+total+" items to be delivered", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Data Not inserted!", Toast.LENGTH_SHORT).show();
            }

            startActivity(i2);
        }

    }

    //Adding quantities of all the food items
    public int addQuantities(int q1,int q2,int q3){
        return q1 + q2 + q3;
    }

    //Cancel Order button method
    public void deleteData(View view){
        int order_ID;

        if (orderID != null){
            DBHelperOrder dbHelperOrder = new DBHelperOrder(this);
            order_ID = Integer.parseInt(orderID);
            dbHelperOrder.deleteOrder(order_ID);
        }
        Intent i2 = new Intent(OrderConfirmation.this,dashboard.class);
        startActivity(i2);
    }
}