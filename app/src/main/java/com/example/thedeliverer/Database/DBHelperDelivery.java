package com.example.thedeliverer.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperDelivery extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "foodFestive.db";
    public static final String TABLE_NAME1= "rider";
    public static final String TABLE1_COLUMN_1= "ID";
    public static final String TABLE1_COLUMN_2= "Name";
    public static final String TABLE1_COLUMN_3= "Contact";
    public static final String TABLE1_COLUMN_4= "VehicleNum";

    public static final String TABLE_NAME2= "delivery";
    public static final String TABLE2_COLUMN_1= "ID";
    public static final String TABLE2_COLUMN_2= "OrderNo";
    public static final String TABLE2_COLUMN_3= "RiderID";
    public static final String TABLE2_COLUMN_5= "Contact";

    public static DBHelperDelivery dbhelper;

//constructor of helper class
    public DBHelperDelivery(Context context){
        super(context,DATABASE_NAME,null,1);

    }

//Method to drop tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }

    //Creating the tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  " + TABLE_NAME1 + " (ID TEXT PRIMARY KEY, NAME TEXT , CONTACT INTEGER, VEHICLE TEXT)");
        db.execSQL("CREATE TABLE  " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,ORDERNO TEXT, RIDERID TEXT, CONTACT INTEGER, FOREIGN KEY (RIDERID) REFERENCES rider(ID)) ");


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
}
