package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText firstName, lastName,email,password,cPassword,phone;
    private Button login, register;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDb = new DatabaseHelper(this);

        firstName = (EditText)findViewById(R.id.fName);
        lastName = (EditText)findViewById(R.id.lName);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        cPassword = (EditText)findViewById(R.id.cPassword);
        phone=(EditText)findViewById(R.id.phone);

        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);
        addData();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, addAddress.class);
                startActivity(intent);


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
    public void addData(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean result= myDb.insertUserDetails(firstName.getText().toString(),lastName.getText().toString(),
                        email.getText().toString(),password.getText().toString());
            if(result=true){
                Toast.makeText(Register.this,"Data inserted",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(Register.this,"Data is not inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}