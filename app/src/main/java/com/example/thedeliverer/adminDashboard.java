package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class adminDashboard extends AppCompatActivity {

    private Button add, update,delete;
    private Button addRider, viewRider,deleteRider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        add = (Button)findViewById(R.id.add);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);

        addRider = (Button)findViewById(R.id.addRider);
        viewRider = (Button)findViewById(R.id.viewRider);
        deleteRider = (Button)findViewById(R.id.deleteRider);


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


        addRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminDashboard.this,AddRider.class);
                startActivity(intent);
            }
        });

        viewRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(adminDashboard.this,ViewRiders.class);
                startActivity(intent);
            }
        });

        deleteRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(adminDashboard.this,updateItem.class);
                startActivity(intent);
            }
        });
    }
}