package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
    TextView item1,item2,item3,item4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intentGet= getIntent();
        userEmail= intentGet.getStringExtra(Register.EMAIL);

        item1 = this.findViewById(R.id.textViewItem1);
        item2 = this.findViewById(R.id.textViewItem2);
        item3 = this.findViewById(R.id.textViewItem3);
        item4 = this.findViewById(R.id.textViewItem4);

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

    public void readRecords() {

        List<Item> items = new ItemControl(this).getAllItem();

        if (items.size() > 0) {
            for (Item i : items) {

                int id = i.id;
                String name = i.name;
                String desc = i.description;
                String price = i.price;

                String textViewContents = "Item name : " + name + "\n" + "Item description : " + desc + "\n" + "Item Price : " + price + "\n\n";

                TextView textViewRecordCount = new TextView(this);
                textViewRecordCount.setPadding(100, 10, 10, 10);
                // textViewRecordCount.setCompoundDrawablePadding(2);
                textViewRecordCount.setTextSize(15);
                textViewRecordCount.setText(textViewContents);
                textViewRecordCount.setTag(id);

                //Calling OnLongClickListener class to do the delete function
                textViewRecordCount.setOnLongClickListener(new DeleteItemOnClick());



            }

        } else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);


        }
    }
}