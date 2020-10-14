package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thedeliverer.Database.ObjectRider;

public class addItem extends AppCompatActivity {
        private EditText itemName,itemType,itemPrice,itemDesc;
        private Button add,back;
        DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        myDb = new DatabaseHelper(this);

        itemName = (EditText)findViewById(R.id.iName);
        itemType = (EditText)findViewById(R.id.iType);
        itemPrice = (EditText)findViewById(R.id.iPrice);
        itemDesc = (EditText)findViewById(R.id.iDesc);

        add = (Button)findViewById(R.id.add);
        back = (Button)findViewById(R.id.back);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
                Intent intent = new Intent(addItem.this,adminDashboard.class);
                startActivity(intent);
                Item item = new Item();
                item.name = itemName.getText().toString();
                item.type = itemType.getText().toString();
                item.price = itemPrice.getText().toString();
                item.description=itemDesc.getText().toString();


                //validations
                String name = itemName.getText().toString().trim();
                String type = itemType.getText().toString().trim();
                String price =itemPrice.getText().toString().trim();



                if(name.isEmpty()){
                    itemName.setError("Required");

                }

                if(type.isEmpty()){
                    itemType.setError("Required");

                }

                if(price.isEmpty()){
                    itemPrice.setError("Required");

                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addItem.this,adminDashboard.class);
                startActivity(intent);
            }
        });


    }
    public void addItem(){
        boolean result = myDb.insertItem(itemName.getText().toString(), itemType.getText().toString(),
                itemPrice.getText().toString(), itemDesc.getText().toString());
        if (result = true) {
            Toast.makeText(addItem.this, "Item  Added succesfully", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(addItem.this, "Item is not added successfully", Toast.LENGTH_LONG).show();

    }



}