package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class adminDashboard extends AppCompatActivity {

    private Button add, update,delete,delivery;
    //private Button addRider, viewRider,deleteRider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        add = (Button)findViewById(R.id.add);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);
        delivery=(Button)findViewById(R.id.delivery);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminDashboard.this,addItem.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(adminDashboard.this,deletItem.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(adminDashboard.this,updateItem.class);
                startActivity(intent);
            }
        });

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(adminDashboard.this,ViewDelivery.class);
                startActivity(intent);
            }
        });

    }
}