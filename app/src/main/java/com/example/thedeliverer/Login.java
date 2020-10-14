package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText email,password;
    private Button login, register,adminLogin;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDb = new DatabaseHelper(this);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);
        adminLogin = (Button)findViewById(R.id.admin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // validate(email.getText().toString(), password.getText().toString());
              // boolean success=
                myDb.checkUser(email.getText().toString(), password.getText().toString());

              /***
               *  if(success=true){
               *                    Intent intent = new Intent(Login.this,dashboard.class);
               *                }
               *                else{
               *                    Toast.makeText(Login.this, "Incorrect Login", Toast.LENGTH_SHORT).show();
               *                }**/
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,adminLogin.class);
                startActivity(intent);
            }
        });
    }
    public void validate(String name, String password){
        if(name.equals("User")&& password.equals("1234")) {
            Intent intent = new Intent(Login.this, dashboard.class);
            startActivity(intent);
        }

        else{
            Toast.makeText(Login.this, "Incorrect Login", Toast.LENGTH_SHORT).show();
        }


    }


}