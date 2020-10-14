package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard extends AppCompatActivity {
    private String userEmail;
    private String userPhone;
    private String fName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intentGet= getIntent();
        userEmail= intentGet.getStringExtra(Register.EMAIL);

        // NavigationView navigationView=findViewById(R.id.bottom_nav);
        //navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener(){


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    break;
                case R.id.navigation_order:
                    Intent intent = new Intent(dashboard.this,OrderConfirmation.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_cart:
                  //  Intent intent_del= new Intent(dashboard.this,ViewDelivery.class);
                 //   startActivity(intent_del);
                    break;
                case R.id.navigation_user:
                    Intent intent_user = new Intent(dashboard.this,userProfile.class);
                    startActivity(intent_user);
                    break;


            }


            return true;
        }
    };
}