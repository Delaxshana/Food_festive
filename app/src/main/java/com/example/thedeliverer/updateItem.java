package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thedeliverer.Database.TableControllerDelivery;

public class updateItem extends AppCompatActivity {
    EditText name, desc, price;
    Button update;
    TableControllerDelivery mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);

        mydb = new TableControllerDelivery(this);
        name = findViewById(R.id.itemNameUpdate);
        desc = findViewById(R.id.itemDescUpdate);
        price = findViewById(R.id.itemPriceUpdate);
        update = findViewById(R.id.updateItem);
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
                            Toast.makeText(updateItem.this, "Fill required fields", Toast.LENGTH_SHORT).show();
                        } else {

                            //update method called from tablecontrollerdelivery class
                            boolean isUpdate = mydb.updateDelivery(name.getText().toString(), desc.getText().toString(), price.getText().toString());


                            //checking whether updated or not
                            if (isUpdate = true) {
                                Toast.makeText(updateItem.this, "Data successfully updated", Toast.LENGTH_SHORT).show();

                                Intent i1 = new Intent(updateItem.this, adminDashboard.class);
                                startActivity(i1);
                            } else {
                                Toast.makeText(updateItem.this, "Data not successfully updated", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }
                }
        );
    }
}