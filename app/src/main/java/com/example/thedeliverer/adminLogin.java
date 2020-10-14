package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminLogin extends AppCompatActivity {
    private EditText uName,password;
    private Button login,userLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        uName = (EditText)findViewById(R.id.uName);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        userLogin = (Button)findViewById(R.id.admin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(uName.getText().toString(), password.getText().toString());
                Intent intent = new Intent(adminLogin.this,adminDashboard.class);
            }
        });





    }
    public void validate(String name, String password){
        if(name.equals("Admin")&& password.equals("123")) {
            Intent intent = new Intent(adminLogin.this, adminDashboard.class);
            startActivity(intent);
        }

        else{
            Toast.makeText(adminLogin.this, "Incorrect Login", Toast.LENGTH_SHORT).show();
        }


    }

}