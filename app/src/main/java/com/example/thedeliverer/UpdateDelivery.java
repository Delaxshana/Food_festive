package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UpdateDelivery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delivery);


        Button btnUpdate = this.findViewById(R.id.updateDeliv);

        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(UpdateDelivery.this,ViewDelivery.class);
                startActivity(i1);

                Context context = getApplicationContext();
                CharSequence message = "Delivery Updated";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }
        });
    }
}