package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class userProfile extends AppCompatActivity {

    Button edit;
    TextView fname,lname,ph;
    LinearLayout linearLayoutRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        fname=(TextView) findViewById(R.id.fName);
        lname=(TextView) findViewById(R.id.lName);
        ph=(TextView) findViewById(R.id.phoneNo);

        linearLayoutRecords = this.findViewById(R.id.layout);
        readRecords();
//        fname.setText(getIntent().getStringExtra("firstName"));
//        lname.setText(getIntent().getStringExtra("lastName"));
//        ph.setText(getIntent().getStringExtra("phoneNo"));

        edit=(Button) findViewById(R.id.edit);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditUserProfile();
            }
        });



    }
    public void openEditUserProfile(){
        Intent intent = new Intent(userProfile.this,editUser.class);
        startActivity(intent);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener(){


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    Intent intent_home = new Intent(userProfile.this,dashboard.class);
                    startActivity(intent_home);
                    break;
                case R.id.navigation_order:
                    Intent intent = new Intent(userProfile.this,OrderDetails.class);
                    startActivity(intent);
                    //selectedFragment = new BookingFragment();
                    break;
                case R.id.navigation_cart:

                    break;
                case R.id.navigation_user:
                    Intent intent_user = new Intent(userProfile.this,userProfile.class);
                    startActivity(intent_user);

                    break;


            }


            return true;
        }
    };
    public void readRecords() {

        linearLayoutRecords.removeAllViews();
        User u=new UserControl(this).getSpecificUser();
        int id = u.id;
        String name = u.fname;
        String email = u.email;
        String phone = u.phone;

        TextView fname = new TextView(this);
        fname.setText(name);

        linearLayoutRecords.addView(fname);



    }
}