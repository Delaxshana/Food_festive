package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class dashboard extends AppCompatActivity {
    private String userEmail;
    private String userPhone;
    private String fName;
    LinearLayout item1Layout, item2Layout, item3Layout, item4Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intentGet = getIntent();
        userEmail = intentGet.getStringExtra(Register.EMAIL);

        item1Layout = this.findViewById(R.id.item1Desc);
        item2Layout = this.findViewById(R.id.item2Desc);
        item3Layout = this.findViewById(R.id.item3Desc);
        item3Layout = this.findViewById(R.id.item4Desc);


        // NavigationView navigationView=findViewById(R.id.bottom_nav);
        //navigationView.setNavigationItemSelectedListener(this);

        readRecordItem1();
        readRecordItem2();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    break;
                case R.id.navigation_search:

                    break;
                case R.id.navigation_cart:
                    //  Intent intent_del= new Intent(dashboard.this,ViewDelivery.class);
                    //   startActivity(intent_del);
                    break;
                case R.id.navigation_user:
                    Intent intent_user = new Intent(dashboard.this, userProfile.class);
                    startActivity(intent_user);
                    break;


            }

            return true;
        }
    };
    public void readRecordItem1() {

        item1Layout.removeAllViews();

        Item item1 = new ItemControl(this).getspecificItem("1");

        int item1Id=1;
        String name1 = item1.name;
        String desc1= item1.description;
        String price1 = item1.price;

        String textViewContentsItem1 =  name1 + "\n" +  desc1 + "\n" + price1 + "\n\n";

        TextView textViewRecordCount1 = new TextView(this);
        textViewRecordCount1.setPadding(100, 10, 10, 10);
        textViewRecordCount1.setTextSize(15);
        textViewRecordCount1.setText(textViewContentsItem1);
        textViewRecordCount1.setTag(item1Id);

        item1Layout.addView(textViewRecordCount1);


    }
    public void readRecordItem2() {

        item2Layout.removeAllViews();


        Item item2 = new ItemControl(this).getspecificItem("2");
        int item2Id=2;
        String name2 = item2.name;
        String desc2= item2.description;
        String price2 = item2.price;

        String textViewContentsItem2 =  name2 + "\n" +  desc2 + "\n" + price2 + "\n\n";

        TextView textViewRecordCount2 = new TextView(this);
        textViewRecordCount2.setPadding(100, 10, 10, 10);
        textViewRecordCount2.setTextSize(15);
        textViewRecordCount2.setText(textViewContentsItem2);
        textViewRecordCount2.setTag(item2Id);


        item2Layout.addView(textViewRecordCount2);


    }
    public void readRecordItem3() {

        item3Layout.removeAllViews();

        Item item3 = new ItemControl(this).getspecificItem("5");

        int item3Id=3;
        String name3 = item3.name;
        String desc3= item3.description;
        String price3 = item3.price;

        String textViewContentsItem3 =  name3 + "\n" +  desc3 + "\n" + price3 + "\n\n";

        TextView textViewRecordCount3 = new TextView(this);
        textViewRecordCount3.setPadding(100, 10, 10, 10);
        textViewRecordCount3.setTextSize(15);
        textViewRecordCount3.setText(textViewContentsItem3);
        textViewRecordCount3.setTag(item3Id);

        item3Layout.addView(textViewRecordCount3);


    }
    public void readRecordItem4() {

        Item item4 = new ItemControl(this).getspecificItem("6");

        int item4Id=4;
        String name4 = item4.name;
        String desc4= item4.description;
        String price4= item4.price;

        String textViewContentsItem4 =  name4 + "\n" +  desc4 + "\n" + price4 + "\n\n";

        TextView textViewRecordCount4 = new TextView(this);
        textViewRecordCount4.setPadding(100, 10, 10, 10);
        textViewRecordCount4.setTextSize(15);
        textViewRecordCount4.setText(textViewContentsItem4);
        textViewRecordCount4.setTag(item4Id);

        // item4Layout.addView(textViewRecordCount4);

    }

}



