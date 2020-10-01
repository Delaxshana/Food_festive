package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addAddress extends AppCompatActivity {
    private EditText doorNo, streetName,city,notes;
    private Button add, addLater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        doorNo = (EditText)findViewById(R.id.doorNo);
        streetName = (EditText)findViewById(R.id.streetNo);
        city = (EditText)findViewById(R.id.city);
        notes = (EditText)findViewById(R.id.notes);

        add = (Button)findViewById(R.id.add);
        addLater = (Button)findViewById(R.id.addlater);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addAddress.this, dashboard.class);
                startActivity(intent);
            }
        });

        addLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addAddress.this, dashboard.class);
                startActivity(intent);
            }
        });
    }
}