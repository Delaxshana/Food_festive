package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewDelivery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delivery);

        Button btnRider = this.findViewById(R.id.AddRider);
        Button btnDelivery = this.findViewById(R.id.AddDel);

        btnRider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(ViewDelivery.this,AddRider.class);
                startActivity(i1);
            }
        });

        btnDelivery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ViewDelivery.this,AddDelivery.class);
                startActivity(i2);
            }
        });


    }





}