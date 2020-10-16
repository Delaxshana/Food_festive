package com.example.thedeliverer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import com.example.thedeliverer.Database.TableControllerDelivery;

public class DeleteItemOnClick implements View.OnLongClickListener{
    Context context;
    String id;
    @Override

    public boolean onLongClick(View view) {

        context = view.getContext();
        id = view.getTag().toString();

        final CharSequence[] items = { "Conform" , "Cancel"};


        new AlertDialog.Builder(context).setTitle("Conform Delete")

                .setItems(items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {

                        if (item == 0) {
                            boolean deleteSuccessful = new ItemControl(context).delete(Integer.parseInt(id));

                            if (deleteSuccessful){

                                Toast.makeText(context, "item id: "+id+" item deleted.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context, "Unable to delete item.", Toast.LENGTH_SHORT).show();

                            }

                            ((deletItem) context).countRecords();

                            ((deletItem) context).readRecords();

                        }

                        else if(item == 1){
                            dialog.dismiss();
                        }


                    }

                }).show();
        return false;
    }
}
