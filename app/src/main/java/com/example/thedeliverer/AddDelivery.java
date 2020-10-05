package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelperDelivery;

public class AddDelivery extends AppCompatActivity {

    EditText ID,RiderID,RiderName;
    EditText Contact;
    Button btnDeliv;
    DBHelperDelivery mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery);


        mydb = new DBHelperDelivery(this);

        ID = findViewById(R.id.addOrder);
        RiderID=findViewById(R.id.addRiderID);
        RiderName=findViewById(R.id.addRiderName);
        Contact = findViewById(R.id.addContactNumber);
        btnDeliv = (Button)this.findViewById(R.id.AddDeliv);

        addDeliveryData();

    }

    public void addDeliveryData (){

        btnDeliv.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = mydb.insertRider(ID.getText().toString(),RiderID.getText().toString(),RiderName.getText().toString(),Contact.getText().toString());

                        if(isInserted = true){
                            Toast.makeText(AddDelivery.this,"Data successfully inserted",Toast.LENGTH_SHORT).show();

                            Intent i1 = new Intent(AddDelivery.this,ViewDelivery.class);
                            startActivity(i1);
                        }
                        else{
                            Toast.makeText(AddDelivery.this,"Data not successfully inserted",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


    }






}