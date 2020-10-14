package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

public class Register extends AppCompatActivity {
     public static final String EMAIL ="email";
    private EditText firstName, lastName,email,password,cPassword,phone;
    private Button login, register,showHideBtn;
    private AppCompatCheckBox checkbox;
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

        checkbox = (AppCompatCheckBox) findViewById(R.id.checkbox);

        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em = email.getText().toString().trim();
                String pw = password.getText().toString().trim();
                String cpw = cPassword.getText().toString().trim();

                if (TextUtils.isEmpty(em)) {
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(pw)) {
                    password.setError("password is required");
                    return;
                }
                if (pw.length() < 8) {
                    password.setError("Password Must be more than 8 characters");
                    return;
                }
                if (phone.length()<10 || phone.length()>10) {
                    phone.setError("Enter a right mobile number");
                }


                /** if(pw!=cpw){
                 password.setError("Password not matching");
                 return;
                 }**/


                addData();
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


        /**checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (!isChecked) {
        // show password
        password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
        // hide password
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        }
        });
         **/

    }
    public void addData() {

        boolean result = myDb.insertUserDetails(firstName.getText().toString(), lastName.getText().toString(),
                email.getText().toString(), password.getText().toString(),phone.getText().toString());
        if (result = true) {
            Toast.makeText(Register.this, "Registered succesfully", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(Register.this, "Not Registered ", Toast.LENGTH_LONG).show();

    }

}