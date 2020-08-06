package com.example.thedeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void navigationOne(View view){
        Intent intent;
        intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void navigationTwo(View view){
        Intent intent;
        intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}