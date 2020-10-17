package com.example.thedeliverer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class updateItem extends AppCompatActivity {
    Button btn;
    TextView textViewRecordCount;
    LinearLayout linearLayoutRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);

        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(updateItem.this,UpdateItemInput.class);
                startActivity(intent);
            }
        });

        textViewRecordCount = this.findViewById(R.id.count);
        linearLayoutRecords = this.findViewById(R.id.records);

        countRecords();
        readRecords();

    }

    public void countRecords() {
        int recordCount = new ItemControl(this).count();
        TextView textViewRecordCount = (TextView) findViewById(R.id.count);
        textViewRecordCount.setText(recordCount + " Items in the list");

    }

    public void readRecords() {

        linearLayoutRecords.removeAllViews();

        List<Item> items = new ItemControl(this).getAllItem();

        if (items.size() > 0) {
            for (Item i : items) {

                int id = i.id;
                String name = i.name;
                String desc = i.description;
                String price = i.price;

                String textViewContents = "Item ID : " + id + "\n" + "Item name : " + name + "\n" + "Item description : " + desc + "\n" + "Item Price : " + price + "\n\n";

                TextView textViewRecordCount = new TextView(this);
                textViewRecordCount.setPadding(100, 10, 10, 10);
                // textViewRecordCount.setCompoundDrawablePadding(2);
                textViewRecordCount.setTextSize(15);
                textViewRecordCount.setText(textViewContents);
                textViewRecordCount.setTag(id);

                //Calling OnLongClickListener class to do the delete function
               // textViewRecordCount.setOnLongClickListener(new UpdateItemOnClick());
                textViewRecordCount.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(updateItem.this,UpdateItemInput.class);
                                startActivity(intent);
                            }
                        }
                );
                linearLayoutRecords.addView(textViewRecordCount);

            }

        } else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            linearLayoutRecords.addView(locationItem);

        }
    }
}