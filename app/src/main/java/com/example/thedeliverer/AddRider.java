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

public class AddRider extends AppCompatActivity {

    EditText RiderID,RiderName,VehicleNum;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rider);

        RiderID=findViewById(R.id.riderID);
        RiderName=findViewById(R.id.riderName);
       // Contact = findViewById(R.id.ContactNum);
        VehicleNum=findViewById(R.id.VehicleNum);



        //Button btnRide = this.findViewById(R.id.AddRide);

        //btnRide.setOnClickListener(new View.OnClickListener(){

          //  public void onClick(View view) {
                //Intent i1 = new Intent(AddRider.this,ViewDelivery.class);
                //startActivity(i1);

                //Context context = getApplicationContext();
                //CharSequence message = "Rider Added";
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, message, duration);
                //toast.show();
            //}
        //});
    }

    public void addData(View view){
        DBHelperDelivery dbhelperdelivery = new DBHelperDelivery(this);



        //String s = Contact.getText().toString();
        //num = Integer.parseInt(s);



        long val = dbhelperdelivery.addRiderInfo(RiderID.getText().toString(),RiderName.getText().toString(),VehicleNum.getText().toString());

        if(val>0){
            Toast.makeText(this,"Data successfully inserted",Toast.LENGTH_SHORT).show();

            Intent i1 = new Intent(AddRider.this,ViewDelivery.class);
            startActivity(i1);

        }
        else{
            Toast.makeText(this,"Data not successfully inserted",Toast.LENGTH_SHORT).show();
        }

    }
}