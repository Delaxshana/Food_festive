package com.example.thedeliverer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.bottomnav,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent1 = new Intent(dashboard.this,dashboard.class);
                startActivity(intent1);
                return true;
            case R.id.cart:
                Intent intent2 = new Intent(dashboard.this,dashboard.class);
                startActivity(intent2);
                return true;
            case R.id.pay:
                Intent intent3 = new Intent(dashboard.this,dashboard.class);
                startActivity(intent3);
                return true;
            case R.id.user:
                Intent intent4 = new Intent(dashboard.this,user.class);
                startActivity(intent4);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

}