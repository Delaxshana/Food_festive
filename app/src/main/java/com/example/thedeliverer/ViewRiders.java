//IT number - IT19085104
//Name - Somawansa R.P.
//This is for delivery component
package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thedeliverer.Database.ObjectDelivery;
import com.example.thedeliverer.Database.ObjectRider;
import com.example.thedeliverer.Database.OnLongClickListenerDelivery;
import com.example.thedeliverer.Database.TableControllerDelivery;

import java.util.List;

public class ViewRiders extends AppCompatActivity {

LinearLayout linearLayoutRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_riders);

        //Initializing variables with resource values
        linearLayoutRecords = findViewById(R.id.riderRecords);

        //Calling method
        readRecords();
    }



    //Method to view records on activity
    public void readRecords(){

        linearLayoutRecords.removeAllViews();

        List<ObjectRider> riders = new TableControllerDelivery(this).readRider();

        if (riders.size() > 0) {

            for (ObjectRider obj : riders) {

                //Initializing rider objects in rider array
              String riderID = obj.riderID;
              String riderFirstName = obj.riderFirstName;
              String riderLastName = obj.riderLastName;
              String contact = obj.contact;
              String vehicleNum = obj.vehicleNum;

              //Formatting it to view on activity
                String textViewContents = "Rider ID: " +riderID+"\n" +"Rider firstname: "+riderFirstName+"\n"+"Rider lastname: "+riderLastName+"\n"+"Contact: "+contact+"\n"+"Vehicle Number: "+vehicleNum+"\n\n"+"------------------------------------------------------------------------------";


                TextView textViewRiderItem= new TextView(this);
                textViewRiderItem.setPadding(0, 10, 0, 10);
                textViewRiderItem.setText(textViewContents);
                textViewRiderItem.setTag(riderID);


                linearLayoutRecords.addView(textViewRiderItem);

            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records.");
            linearLayoutRecords.addView(locationItem);

        }

    }



}