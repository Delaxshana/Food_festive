//IT number - IT19085104
//Name - Somawansa R.P.
//This is for delivery component
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
import com.example.thedeliverer.Database.ObjectDelivery;
import com.example.thedeliverer.Database.TableControllerDelivery;

public class AddDelivery extends AppCompatActivity {

    EditText ID,RiderID;
    EditText Contact;
    Button btnDeliv;
    DBHelperDelivery mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery);

        //Intializing variables with respective resource values
        mydb = new DBHelperDelivery(this);

        ID = findViewById(R.id.addOrder);
        RiderID=findViewById(R.id.addRiderID);
        Contact = findViewById(R.id.addContactNumber);
        btnDeliv = (Button)this.findViewById(R.id.AddDeliv);

        //Checking whether phone number is valid
        if (Contact.length()<10 || Contact.length()>10) {
            Contact.setError("Enter a right mobile number");
        }

        if (ID.equals(null)) {
            ID.setError("Required");
        }

        if (RiderID.equals(null)) {
            RiderID.setError("Required");
        }


 //calling method
        addDeliveryData();

    }

    //method to add data from activity
    public void addDeliveryData () {

        btnDeliv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Intializing read values from activity with vaiables of delivery object
                        ObjectDelivery objectDelivery = new ObjectDelivery();
                        objectDelivery.orderNo = ID.getText().toString();
                        objectDelivery.riderID = RiderID.getText().toString();
                        objectDelivery.contact =  Contact.getText().toString();

                        //Checking whether inserted or not
                        boolean createSuccessful = new TableControllerDelivery(AddDelivery.this).create(objectDelivery);
                        if (createSuccessful = true) {
                            Toast.makeText(AddDelivery.this, "Data successfully inserted", Toast.LENGTH_SHORT).show();

                            Intent i1 = new Intent(AddDelivery.this, ViewDelivery.class);
                            startActivity(i1);
                        } else {
                            Toast.makeText(AddDelivery.this, "Data not successfully inserted", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
        );


    }








    }