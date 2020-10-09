package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thedeliverer.Database.ObjectDelivery;
import com.example.thedeliverer.Database.OnLongClickListenerDelivery;
import com.example.thedeliverer.Database.TableControllerDelivery;

import java.util.List;

public class ViewDelivery extends AppCompatActivity {




    Button btnUpdate,btnRider,btnViewRider,btnDelivery;
    TextView textViewRecordCount;
   LinearLayout linearLayoutRecords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delivery);

         //Initializing buttons with resource values
         btnRider = this.findViewById(R.id.AddRider);
         btnDelivery = this.findViewById(R.id.AddDel);
         btnUpdate = this.findViewById(R.id.Update);
        btnViewRider = this.findViewById(R.id.ViewRider);

        //Intializing text view and linear layout with reosurce values
        textViewRecordCount = this.findViewById(R.id.count);
        linearLayoutRecords = this.findViewById(R.id.records);


        //Button click events of the buttons
        btnRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(ViewDelivery.this, AddRider.class);
                startActivity(i1);
            }
        });

        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ViewDelivery.this, AddDelivery.class);
                startActivity(i2);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
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

    //method to display numner of records in delivery table
    public void countRecords()
    {
        int recordCount = new TableControllerDelivery(this).count();
        TextView textViewRecordCount = (TextView) findViewById(R.id.count);
        textViewRecordCount.setText(recordCount + " records found.");

    }


    //method to display read records from database
        public void readRecords(){

        linearLayoutRecords.removeAllViews();

        //Creating deliveries array
            List<ObjectDelivery> deliveries = new TableControllerDelivery(this).read();

            if (deliveries.size() > 0) {

                for (ObjectDelivery obj : deliveries) {

                    //Intializing variables in deliveries object array
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

                    //Calling OnLongClickListner class to do the delete function
                    textViewDeliveryItem.setOnLongClickListener(new OnLongClickListenerDelivery());


                    linearLayoutRecords.addView(textViewDeliveryItem);

                }

            }

            else {

                TextView locationItem = new TextView(this);
                locationItem.setPadding(8, 8, 8, 8);
                //locationItem.setText("No records yet.");
                linearLayoutRecords.addView(locationItem);

            }

        }






    }











