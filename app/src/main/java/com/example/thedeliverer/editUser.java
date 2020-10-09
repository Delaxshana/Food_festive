package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class editUser extends AppCompatActivity {
    Button conform,back;

    EditText fName;
    EditText lName;
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        fName=(EditText) findViewById(R.id.fName);
        lName=(EditText) findViewById(R.id.lName);
        phone=(EditText) findViewById(R.id.phone);

        conform=(Button) findViewById(R.id.conform);
        back=(Button) findViewById(R.id.back);

        conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fNamevalue=fName.getText().toString();
                String lNamevalue=lName.getText().toString();
                String phonenovalue=phone.getText().toString();

                Intent intent = new Intent(editUser.this,user.class);
                intent.putExtra("firstName",fNamevalue);
                intent.putExtra("lastName",lNamevalue);
                intent.putExtra("phoneNo",phonenovalue);
                startActivity(intent);
            }
        });

    }
}