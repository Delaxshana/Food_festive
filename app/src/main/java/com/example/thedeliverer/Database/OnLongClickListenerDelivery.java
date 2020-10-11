//IT number - IT19085104
//Name - Somawansa R.P.
//This is for delivery component
package com.example.thedeliverer.Database;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import com.example.thedeliverer.ViewDelivery;

public class OnLongClickListenerDelivery implements View.OnLongClickListener {
    Context context;
    String id;


    //This method is used to delete a record when that record is clicked and held for a while
    @Override
    public boolean onLongClick(View view) {

        context = view.getContext();
        id = view.getTag().toString();

        final CharSequence[] items = { "Yes" , "No"};

        //Using a dialog box to do the delete function
        new AlertDialog.Builder(context).setTitle("Delete \n"+"Are you sure you want to delete")

                .setItems(items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {

                        if (item == 0) {
                            boolean deleteSuccessful = new TableControllerDelivery(context).delete(Integer.parseInt(id));

                            if (deleteSuccessful){

                                Toast.makeText(context, "Delivery id: "+id+" record was deleted.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context, "Unable to delete record.", Toast.LENGTH_SHORT).show();

                            }

                            ((ViewDelivery) context).countRecords();

                            ((ViewDelivery) context).readRecords();

                        }

                        else if(item == 1){
                            dialog.dismiss();
                        }

                        //dialog.dismiss();

                    }

                }).show();
        return false;
    }


}
