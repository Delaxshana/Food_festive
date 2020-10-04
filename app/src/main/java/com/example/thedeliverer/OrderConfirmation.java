package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class OrderConfirmation extends AppCompatActivity {
    RadioButton pickup_btn,delivery_btn;
    EditText date_input, time_input;
    String special_instructions_msg;

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


    }

    public void sendData(View view){
        special_instructions_msg = getIntent().getStringExtra("special_inst");
        Intent i1 = new Intent(OrderConfirmation.this,OrderConfirmation.class);
        if (pickup_btn.isChecked()==true){
            i1.putExtra("ordertype","pickup");
        } else if (delivery_btn.isChecked()==true){
            i1.putExtra("ordertype","delivery");
        }
        i1.putExtra("date_input",date_input.getText().toString());
        i1.putExtra("time_input",time_input.getText().toString());
        i1.putExtra("special_inst",special_instructions_msg);
        startActivity(i1);
    }
}