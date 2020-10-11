//IT number - IT19085104
//Name - Somawansa R.P.
//This is fro delivery component
package com.example.thedeliverer.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TableControllerDelivery extends DBHelperDelivery {

    //Controller class to intialize add , view and delete methods
    public TableControllerDelivery(Context context){
        super(context);
    }

    //Variables
    DBHelperDelivery dbHelper;
    SQLiteDatabase db;

    //Method to insert delivery
    public boolean create(ObjectDelivery objectDelivery)
    {


        ContentValues values = new ContentValues();

        values.put("ORDERNO", objectDelivery.orderNo);
        values.put("RIDERID", objectDelivery.riderID);
        values.put("CONTACT", objectDelivery.contact);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("delivery", null, values) > 0;

        db.close();

        return createSuccessful;

    }

    //method to insert rider
    public boolean createRider(ObjectRider objectRider)
    {


        ContentValues values = new ContentValues();

        values.put("ID", objectRider.riderID);
        values.put("FIRSTNAME", objectRider.riderFirstName);
        values.put("LASTNAME",objectRider.riderLastName);
        values.put("CONTACT", objectRider.contact);
        values.put("VEHICLE", objectRider.vehicleNum);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("rider", null, values) > 0;

        db.close();

        return createSuccessful;

    }



    //method to get number of records in delivery table
    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM delivery";

        int recordCount = db.rawQuery(sql, null).getCount();

        db.close();

        return recordCount;

    }

    //method to list all the records
    public List<ObjectDelivery> read() {

        List<ObjectDelivery> recordsList = new ArrayList<ObjectDelivery>();

        String sql = "SELECT * FROM delivery ORDER BY ID DESC";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID")));
                String orderNo = cursor.getString(cursor.getColumnIndex("ORDERNO"));
                String riderID = cursor.getString(cursor.getColumnIndex("RIDERID"));
                String contact = cursor.getString(cursor.getColumnIndex("CONTACT"));

                //Initializing delivery object with read values from database
                ObjectDelivery objectDelivery = new ObjectDelivery();

                objectDelivery.id = id;
                objectDelivery.orderNo = orderNo;
                objectDelivery.riderID = riderID;
                objectDelivery.contact = contact;

                recordsList.add(objectDelivery);

            } while (cursor.moveToNext());

        }

        cursor.close();

        db.close();

        return recordsList;

    }

    //methhod to list rider records
    public List<ObjectRider> readRider() {

        List<ObjectRider> recordsList = new ArrayList<ObjectRider>();

        String sql = "SELECT * FROM rider";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                String riderID = cursor.getString(cursor.getColumnIndex("ID"));
                String riderFirstName = cursor.getString(cursor.getColumnIndex("FIRSTNAME"));
                String riderLastName = cursor.getString(cursor.getColumnIndex("LASTNAME"));
                String contact = cursor.getString(cursor.getColumnIndex("CONTACT"));
                String vehicleNum = cursor.getString(cursor.getColumnIndex("VEHICLE"));

                //Initializing rider object from data of rider table
                ObjectRider objectrider = new ObjectRider();

                objectrider.riderID = riderID;
                objectrider.riderFirstName=riderFirstName;
                objectrider.riderLastName=riderLastName;
                objectrider.contact=contact;
                objectrider.vehicleNum=vehicleNum;

                recordsList.add(objectrider);

            } while (cursor.moveToNext());

        }

        cursor.close();

        db.close();

        return recordsList;

    }

    //method to update delivery records
    public boolean updateDelivery(String id,String riderID,String Contact){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE2_COLUMN_1,id);
        values.put(TABLE2_COLUMN_3,riderID);
        values.put(TABLE2_COLUMN_5,Contact);
        db.update(TABLE_NAME2,values,"ID = ?",new String[]  { id });

        return true;

    }

    //method to delete a record when the id is passed as a parameter
    public boolean delete(int id) {

        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();

        deleteSuccessful = db.delete("delivery", "ID ='" + id + "'", null) > 0;

        db.close();

        return deleteSuccessful;

    }


}


