package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addAddress extends AppCompatActivity {
    private EditText doorNo, streetName,city,notes;
    private Button add, addLater;
    DatabaseHelper db;
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
                addAddress();
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
    public void addAddress(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result= db.insertUserAddress(doorNo.getText().toString(),streetName.getText().toString(),
                        city.getText().toString(),notes.getText().toString());
                if(result=true){
                    Toast.makeText(addAddress.this,"Address added succesfully",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(addAddress.this,"Address not added",Toast.LENGTH_LONG).show();
            }
        });
    }
}