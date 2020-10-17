package com.example.thedeliverer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class UpdateItemOnClick implements View.OnLongClickListener {
    Context context;
    String id,name,desc,price;

    @Override
    public boolean onLongClick(View v) {
        context = v.getContext();
        name = v.getTag().toString();
        desc = v.getTag().toString();
        price = v.getTag().toString();


        final CharSequence[] items = { "Yes" , "Cancel"};


        new AlertDialog.Builder(context).setTitle("Do to want to update")

                .setItems(items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {

                        if (item == 0) {
                            boolean updateSuccess = new ItemControl(context).updateItem(name,desc,price);

                            if (updateSuccess){
                                Toast.makeText(context, "item id: "+id+" item updated.", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(context, "Unable to update item.", Toast.LENGTH_SHORT).show();

                            }

                            ((updateItem) context).countRecords();

                            ((updateItem) context).readRecords();

                        }

                        else if(item == 1){
                            dialog.dismiss();
                        }


                    }

                }).show();
        return false;
    }
}
