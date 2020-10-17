package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class UpdateItemInput extends AppCompatActivity {
    EditText name, desc, price, id;
    Button update;
    ItemControl mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item_input);
        // mydb = new TableControllerDelivery(this);
        mydb = new ItemControl(this);
        name = findViewById(R.id.itemNameUpdate);
        desc = findViewById(R.id.itemDescUpdate);
        price = findViewById(R.id.itemPriceUpdate);
        update = findViewById(R.id.updateItem);

        UpdateItemData();
    }

    public void UpdateItemData() {


        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //validations

                        String itemName = name.getText().toString().trim();
                        String itemPrice = desc.getText().toString().trim();
                        String itemDesc = price.getText().toString().trim();


                        if (itemName.isEmpty()) {
                            name.setError("Required");
                        }
                        if (itemPrice.isEmpty()) {
                            price.setError("Required");
                        }
                        if (itemDesc.isEmpty()) {
                            desc.setError("Required");
                        }


                        if (itemName.isEmpty() || itemPrice.isEmpty()) {
                            Toast.makeText(UpdateItemInput.this, "Fill required fields", Toast.LENGTH_SHORT).show();
                        } else {

                            //update method called from tablecontrollerdelivery class
                            boolean isUpdate = mydb.updateItem(name.getText().toString(), desc.getText().toString(), price.getText().toString());


                            //checking whether updated or not
                            if (isUpdate = true) {
                                Toast.makeText(UpdateItemInput.this, "Item updated", Toast.LENGTH_SHORT).show();
                                Intent i1 = new Intent(UpdateItemInput.this, adminDashboard.class);
                                startActivity(i1);
                            } else {
                                Toast.makeText(UpdateItemInput.this, "Item is not updated", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }
                }
        );
    }


}