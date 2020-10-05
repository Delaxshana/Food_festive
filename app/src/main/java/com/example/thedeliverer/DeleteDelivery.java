package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thedeliverer.Database.DBHelperDelivery;

import org.w3c.dom.Text;

public class DeleteDelivery extends AppCompatActivity {

    Button btnDeliveryAdd;
    TextView Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_delivery);

        Button btnDeliveryAdd = this.findViewById(R.id.deleteDeliv);
        Id = findViewById(R.id.deleteID);

        btnDeliveryAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(DeleteDelivery.this,ViewDelivery.class);
                startActivity(i1);

                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteDelivery.this);
                builder.setMessage("Are you sure you want to delete?");
                builder.setTitle("Delete");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();;

               // Context context = getApplicationContext();
                //CharSequence message = "Delivery Deleted";
                //int duration = Toast.LENGTH_LONG;
                //Toast toast = Toast.makeText(context, message, duration);
                //toast.show();
            }
        });

    }

    public void deleteData(View view){
        DBHelperDelivery dbHelper = new DBHelperDelivery(this);

        dbHelper.deleteDeliveryInfo(Id.getText().toString());

        Intent i1 = new Intent(DeleteDelivery.this,ViewDelivery.class);

        Toast.makeText(this, Id.getText().toString() + " deleted Successfully", Toast.LENGTH_SHORT).show();

        startActivity(i1);

    }
}