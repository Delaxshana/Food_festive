//IT number - IT19085104
//Name - Somawansa R.P.
//This is for delivery component

package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelperDelivery;
import com.example.thedeliverer.Database.ObjectDelivery;
import com.example.thedeliverer.Database.ObjectRider;
import com.example.thedeliverer.Database.TableControllerDelivery;

public class AddRider extends AppCompatActivity {

    EditText RiderID,RiderFirstName,RiderLastName,VehicleNum;
    EditText Contact;
    Button btnRide;
    DBHelperDelivery mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rider);

        //Initializing helper
       mydb = new DBHelperDelivery(this);

       //Initializing text views
        RiderID=findViewById(R.id.riderID);
        RiderFirstName=findViewById(R.id.riderName);
        RiderLastName = findViewById(R.id.riderLastName);
        Contact = findViewById(R.id.RiderContact);
        VehicleNum=findViewById(R.id.VehicleNum);


        //Initializing button
        btnRide = (Button)this.findViewById(R.id.AddRide);

        //Checking whether phone number's length is not less than 10
        if (Contact.length()<10 || Contact.length()>10) {
            Contact.setError("Enter a right mobile number");
        }

        //Calling add method
        addRiderData();


    }

    public void addRiderData () {


        //Button click
        btnRide.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        //Initializing of delivery object variables with values from activity
                        ObjectRider objectRider = new ObjectRider();
                        objectRider.riderID = RiderID.getText().toString();
                        objectRider.riderFirstName = RiderFirstName.getText().toString();
                        objectRider.riderLastName=RiderLastName.getText().toString();
                        objectRider.contact =  Contact.getText().toString();
                        objectRider.vehicleNum = VehicleNum.getText().toString();

                        //validations
                        String riderID = RiderID.getText().toString().trim();
                        String firstname = RiderFirstName.getText().toString().trim();
                        String lastname = RiderLastName.getText().toString().trim();
                        String contact = Contact.getText().toString().trim();
                        String vehiclenum = VehicleNum.getText().toString().trim();



                        if (Contact.length()<10 || Contact.length()>10) {
                            Contact.setError("Enter a correct mobile number");
                        }

                        if(riderID.isEmpty()){
                            RiderID.setError("Required");

                        }

                        if(firstname.isEmpty()){
                            RiderFirstName.setError("Required");

                        }
                        if(lastname.isEmpty()){
                            RiderLastName.setError("Required");

                        }
                        if(vehiclenum.isEmpty()){
                            VehicleNum.setError("Required");

                        }



                        if(riderID.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || vehiclenum.isEmpty() || contact.isEmpty()){
                            Toast.makeText(AddRider.this,"Fill required fields",Toast.LENGTH_SHORT).show();
                        }
                        else {


                            //Checking whether inserted or not
                            boolean createSuccessful = new TableControllerDelivery(AddRider.this).createRider(objectRider);
                            if (createSuccessful = true) {
                                Toast.makeText(AddRider.this, "Data successfully inserted", Toast.LENGTH_SHORT).show();

                                Intent i1 = new Intent(AddRider.this, ViewDelivery.class);
                                startActivity(i1);
                            } else {
                                Toast.makeText(AddRider.this, "Data not successfully inserted", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }
                }
        );


    }


}