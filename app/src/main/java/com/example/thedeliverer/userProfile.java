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
    LinearLayout fnameLayout, lNameLayout, phoneNoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        fname=(TextView) findViewById(R.id.fName);
        lname=(TextView) findViewById(R.id.lName);
        ph=(TextView) findViewById(R.id.phoneNo);

        edit=(Button) findViewById(R.id.edit);

        fnameLayout = this.findViewById(R.id.fNameLayout);
        lNameLayout = this.findViewById(R.id.lNameLayout);
        phoneNoLayout = this.findViewById(R.id.phoneNoLayout);

        //readFName();
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
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent_home = new Intent(userProfile.this, dashboard.class);
                    startActivity(intent_home);
                    break;
                case R.id.navigation_search:
                    Intent intent = new Intent(userProfile.this, OrderDetails.class);
                    startActivity(intent);
                    //selectedFragment = new BookingFragment();
                    break;
                case R.id.navigation_cart:

                    break;
                case R.id.navigation_user:
                    Intent intent_user = new Intent(userProfile.this, userProfile.class);
                    startActivity(intent_user);

                    break;

            }
            return true;
        }
    };

    public void readFName() {

        fnameLayout.removeAllViews();

        User user = new UserControl(this).getSpecificUser("1");
        int userId=1;
        String fName = user.fname;

        String textViewContentsFName = fName;

        TextView textViewRecordCount1 = new TextView(this);
        textViewRecordCount1.setPadding(100, 10, 10, 10);
        textViewRecordCount1.setTextSize(15);
        textViewRecordCount1.setText(textViewContentsFName);
        textViewRecordCount1.setTag(userId);

        fnameLayout.addView(textViewRecordCount1);

    }
    public void readlName() {

        lNameLayout.removeAllViews();

        User user = new UserControl(this).getSpecificUser("1");
        int userId=1;
        String lName= user.lname;

        String textViewContentsLName=lName;

        TextView textViewRecordCount1 = new TextView(this);
        textViewRecordCount1.setPadding(100, 10, 10, 10);
        textViewRecordCount1.setTextSize(15);
        textViewRecordCount1.setText(textViewContentsLName);
        textViewRecordCount1.setTag(userId);

        fnameLayout.addView(textViewRecordCount1);

    }

    public void readphNo() {

        phoneNoLayout.removeAllViews();

        User user = new UserControl(this).getSpecificUser("1");
        int userId=1;
        String phone = user.phone;

        String textViewContentsPhone = phone;

        TextView textViewRecordCount1 = new TextView(this);
        textViewRecordCount1.setPadding(100, 10, 10, 10);
        textViewRecordCount1.setTextSize(15);
        textViewRecordCount1.setText(textViewContentsPhone);
        textViewRecordCount1.setTag(userId);

        fnameLayout.addView(textViewRecordCount1);

    }

}