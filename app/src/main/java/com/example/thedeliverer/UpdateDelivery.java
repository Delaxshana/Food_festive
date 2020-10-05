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

public class UpdateDelivery extends AppCompatActivity {
EditText Name,ID,Contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delivery);


        Button btnUpdate = this.findViewById(R.id.updateDeliv);

        ID = findViewById(R.id.riderIDupdate);
        Name = findViewById(R.id.nameUpdate);
        Contact = findViewById(R.id.contactUpdate);


      // btnUpdate.setOnClickListener(new View.OnClickListener(){
        //    @Override
          //  public void onClick(View view) {
            //    Intent i1 = new Intent(UpdateDelivery.this,ViewDelivery.class);
              //  startActivity(i1);

                //Context context = getApplicationContext();
                //CharSequence message = "Delivery Updated";
                //int duration = Toast.LENGTH_LONG;
                //Toast toast = Toast.makeText(context, message, duration);
                //toast.show();


           // }
        //});
    }

    public void updateData(View view){
        DBHelperDelivery dbHelper = new DBHelperDelivery(this);

        int val = dbHelper.updateDeliveryInfo(ID.getText().toString(),Name.getText().toString(),Contact.getText().toString());

        Intent i2 = new Intent(UpdateDelivery.this,ViewDelivery.class);
        if (val>0){
            Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Data did not update!", Toast.LENGTH_SHORT).show();
        }

        startActivity(i2);

    }
}