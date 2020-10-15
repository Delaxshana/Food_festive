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
import com.example.thedeliverer.Database.UsersMaster;

public class OrderConfirmation extends AppCompatActivity {
    RadioButton pickup_btn,delivery_btn;
    EditText date_input, time_input;
    String special_instructions_msg,cartID;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        //Initializing all the input values
        pickup_btn = findViewById(R.id.pickup_btn);
        delivery_btn = findViewById(R.id.delivery_btn);
        date_input = findViewById(R.id.date_input);
        time_input = findViewById(R.id.time_input);


        Intent intent = getIntent();
        special_instructions_msg = getIntent().getStringExtra("special_inst");
        cartID = getIntent().getStringExtra("cartId");
        int cart_ID = Integer.parseInt(cartID);

        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        Cursor rs = dbHelperOrder.getCartData(cart_ID);
        rs.moveToFirst();

        String q1 = rs.getString(rs.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY1));
        String q2 = rs.getString(rs.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY2));
        String q3 = rs.getString(rs.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY3));


        if (!rs.isClosed())  {
            rs.close();
        }

        int quantity1 = Integer.parseInt(q1);
        int quantity2 = Integer.parseInt(q2);
        int quantity3 = Integer.parseInt(q3);

        total = quantity1+quantity2+quantity3;


    }

    public void sendData(View view){

        boolean checked = pickup_btn.isChecked();

        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);

        String orderID = dbHelperOrder.addOrderTableInfo(cartID,special_instructions_msg,date_input.getText().toString(),time_input.getText().toString());


        if (checked == true){
            Intent i1 = new Intent(OrderConfirmation.this,OrderConfirmation.class);
            i1.putExtra("total_items",total);
            i1.putExtra("orderID",orderID);

            if (orderID!=null){
                Toast.makeText(this, "Data successfully inserted pickup"+orderID, Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Data Not inserted!", Toast.LENGTH_SHORT).show();
            }

            startActivity(i1);
        }
        else {
            Intent i2 = new Intent(OrderConfirmation.this,OrderConfirmation.class);
            i2.putExtra("total_items",total);
            i2.putExtra("orderID",orderID);

            if (orderID!=null){
                Toast.makeText(this, "Data successfully inserted delivery"+orderID, Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Data Not inserted!", Toast.LENGTH_SHORT).show();
            }

            startActivity(i2);
        }




//        if (pickup_btn.isChecked()==true){
//            i1.putExtra("ordertype","pickup");
//        } else if (delivery_btn.isChecked()==true){
//            i1.putExtra("ordertype","delivery");
//        }
//        i1.putExtra("date_input",date_input.getText().toString());
//        i1.putExtra("time_input",time_input.getText().toString());
//        i1.putExtra("special_inst",special_instructions_msg);

    }

    public void deleteData(View view){
        Intent i2 = new Intent(OrderConfirmation.this,dashboard.class);
        startActivity(i2);
    }
}