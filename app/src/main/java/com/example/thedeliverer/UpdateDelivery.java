package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thedeliverer.Database.DBHelperDelivery;
import com.example.thedeliverer.Database.ObjectDelivery;
import com.example.thedeliverer.Database.TableControllerDelivery;

import org.json.JSONException;

import java.util.ArrayList;

public class UpdateDelivery extends AppCompatActivity {

    EditText order,riderID,riderName,contact,id;
    Button update;
    DBHelperDelivery mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delivery);

        //Initializing variables with resource values
        mydb = new DBHelperDelivery(this);
        id = findViewById(R.id.delivIDUpdate);
        riderID = findViewById(R.id.riderIDupdate);
        contact = findViewById(R.id.contactUpdate);
        update = findViewById(R.id.updateDeliv);

        //Checking whether contact number's digits are not less than 10
        if (contact.length()<10) {
            contact.setError("Enter a correct mobile number");
        }

        //Calling method
        UpdateDeliveryData();


        }

        //Method to updae details in activity
    public void UpdateDeliveryData () {


        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //update method called from dbHelperDelivery
                        boolean isUpdate = mydb.updateDelivery(id.getText().toString(), riderID.getText().toString(), contact.getText().toString());


                        //checking whether updated or not
                        if (isUpdate = true) {
                            Toast.makeText(UpdateDelivery.this, "Data successfully updated", Toast.LENGTH_SHORT).show();

                            Intent i1 = new Intent(UpdateDelivery.this, ViewDelivery.class);
                            startActivity(i1);
                        } else {
                            Toast.makeText(UpdateDelivery.this, "Data not successfully updated", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
        );


    }

    }


