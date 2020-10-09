package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class user extends AppCompatActivity {

    Button edit;

    TextView fname,lname,ph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        fname=(TextView) findViewById(R.id.fName);
        lname=(TextView) findViewById(R.id.lName);
        ph=(TextView) findViewById(R.id.phoneNo);

        fname.setText(getIntent().getStringExtra("firstName"));
        lname.setText(getIntent().getStringExtra("lastName"));
        ph.setText(getIntent().getStringExtra("phoneNo"));

        edit=(Button) findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditUserProfile();
            }
        });



    }
    public void openEditUserProfile(){
        Intent intent = new Intent(user.this,editUser.class);
        startActivity(intent);
    }
}