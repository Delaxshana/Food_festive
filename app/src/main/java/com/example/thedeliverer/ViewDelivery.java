package com.example.thedeliverer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelperDelivery;

public class ViewDelivery extends AppCompatActivity {

    DBHelperDelivery db;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delivery);

         db = new DBHelperDelivery(this);
         btn = findViewById(R.id.View);
        Button btnRider = this.findViewById(R.id.AddRider);
        Button btnDelivery = this.findViewById(R.id.AddDel);

        btnRider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(ViewDelivery.this,AddRider.class);
                startActivity(i1);
            }
        });

        btnDelivery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ViewDelivery.this,AddDelivery.class);
                startActivity(i2);
            }
        });

        viewAll();

    }

    public void viewAll() {
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Cursor res = db.getDeliveryData();
                        StringBuffer buffer = new StringBuffer();

                        while(res.moveToNext()){
                            buffer.append("ID: "+res.getString(0)+ "\n");
                            buffer.append("RiderID: "+res.getString(1)+ "\n");
                            buffer.append("RiderName: "+res.getString(2)+ "\n");
                            buffer.append("Contact: "+res.getString(3)+ "\n\n");



                        }

                        String Message = buffer.toString();
                        showMessage("Data",Message);

                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.setCancelable(true);


        AlertDialog alertDialog = builder.create();
        alertDialog.show();;
    }










}