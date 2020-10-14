//IT number - IT19085104
//name - Somawasna R.P.
//This is for delivery component

package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thedeliverer.Database.ObjectDelivery;
import com.example.thedeliverer.Database.OnLongClickListenerDelivery;
import com.example.thedeliverer.Database.TableControllerDelivery;

import java.util.List;

public class ViewDelivery extends AppCompatActivity {


    //Variables

    Button btnUpdateDelivery,btnAddRider,btnViewRider,btnAddDelivery;
    TextView textViewRecordCount;
    LinearLayout linearLayoutRecords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delivery);

         //Initializing buttons with resource values
         btnAddRider = this.findViewById(R.id.AddRider);
         btnAddDelivery = this.findViewById(R.id.AddDel);
         btnUpdateDelivery = this.findViewById(R.id.Update);
         btnViewRider = this.findViewById(R.id.ViewRider);

        //Initializing text view and linear layout with resource values
        textViewRecordCount = this.findViewById(R.id.count);
        linearLayoutRecords = this.findViewById(R.id.records);


        //Button click events of the buttons
        btnAddRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(ViewDelivery.this, AddRider.class);
                startActivity(i1);
            }
        });

        btnAddDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ViewDelivery.this, AddDelivery.class);
                startActivity(i2);
            }
        });

        btnUpdateDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ViewDelivery.this, UpdateDelivery.class);
                startActivity(i2);
            }
        });

        btnViewRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ViewDelivery.this, ViewRiders.class);
                startActivity(i2);
            }
        });


        //calling methods
        countRecords();
        readRecords();
    }

    //method to display number of records in delivery table
    public void countRecords()
    {
        int recordCount = new TableControllerDelivery(this).count();
        TextView textViewRecordCount = (TextView) findViewById(R.id.count);
        textViewRecordCount.setText(recordCount + " records found.");

    }


    //method to display records from delivery table
        public void readRecords(){

        linearLayoutRecords.removeAllViews();

        //Creating deliveries array
            List<ObjectDelivery> deliveries = new TableControllerDelivery(this).read();

            if (deliveries.size() > 0) {

                for (ObjectDelivery obj : deliveries) {

                    //Initializing variables in deliveries object array
                    int deliveryID = obj.id;
                    String orderNo = obj.orderNo;
                    String riderID = obj.riderID;
                    String contact = obj.contact;

                    //Displaying content
                    String textViewContents = "Delivery ID: " +deliveryID+"\n" +"OrderNo: "+orderNo+"\n"+"RiderID: "+riderID+"\n"+"Contact: "+contact+"\n\n"+"---------------------------------------------------------------------------------------------";


                    TextView textViewDeliveryItem= new TextView(this);
                    textViewDeliveryItem.setPadding(0, 10, 0, 10);
                    textViewDeliveryItem.setText(textViewContents);
                    textViewDeliveryItem.setTag(deliveryID);

                    //Calling OnLongClickListener class to do the delete function
                    textViewDeliveryItem.setOnLongClickListener(new OnLongClickListenerDelivery());


                    linearLayoutRecords.addView(textViewDeliveryItem);

                }

            }

            else {

                TextView locationItem = new TextView(this);
                locationItem.setPadding(8, 8, 8, 8);
                linearLayoutRecords.addView(locationItem);

            }

        }






    }











