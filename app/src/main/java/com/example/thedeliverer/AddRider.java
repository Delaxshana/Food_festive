package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelperDelivery;

public class AddRider extends AppCompatActivity {

    EditText RiderID,RiderName,VehicleNum;
    EditText Contact;
    Button btnRide;
    DBHelperDelivery mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rider);

        mydb = new DBHelperDelivery(this);

        RiderID=findViewById(R.id.riderID);
        RiderName=findViewById(R.id.riderName);
       Contact = findViewById(R.id.RiderContact);
        VehicleNum=findViewById(R.id.VehicleNum);
        btnRide = (Button)this.findViewById(R.id.AddRide);

        addRiderData();

        //btnRide.setOnClickListener(new View.OnClickListener(){

          //public void onClick(View view) {
            //    Intent i1 = new Intent(AddRider.this,ViewDelivery.class);
              //  startActivity(i1);

                //Context context = getApplicationContext();
                //CharSequence message = "Rider Added";
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, message, duration);
                //toast.show();
            //}
        //});
    }

    public void addRiderData (){

      btnRide.setOnClickListener(
              new View.OnClickListener(){
                  @Override
                  public void onClick(View view) {
                      boolean isInserted = mydb.insertRider(RiderID.getText().toString(),RiderName.getText().toString(),Contact.getText().toString(),VehicleNum.getText().toString());

                      if(isInserted = true){
                          Toast.makeText(AddRider.this,"Data successfully inserted",Toast.LENGTH_SHORT).show();

                          Intent i1 = new Intent(AddRider.this,ViewDelivery.class);
                          startActivity(i1);
                      }
                      else{
                          Toast.makeText(AddRider.this,"Data not successfully inserted",Toast.LENGTH_SHORT).show();
                      }
                  }
              }
      );


   }
}