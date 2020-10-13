//IT number - IT19085104
//Name - Somawansa R.P.
//This is for delivery component

package com.example.thedeliverer.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperDelivery extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "foodFestive.db";
    public static final String TABLE_NAME1= "rider";
    public static final String TABLE1_COLUMN_1= "ID";
    public static final String TABLE1_COLUMN_2= "FirstName";
    public static final String TABLE1_COLUMN_3 = "LastName";
    public static final String TABLE1_COLUMN_4= "Contact";
    public static final String TABLE1_COLUMN_5= "VehicleNum";

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
        db.execSQL("CREATE TABLE  " + TABLE_NAME1 + " (ID TEXT PRIMARY KEY, FIRSTNAME TEXT , LASTNAME TEXT,CONTACT TEXT, VEHICLE TEXT)");
        db.execSQL("CREATE TABLE  " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,ORDERNO TEXT NOT NULL, RIDERID TEXT NOT NULL, CONTACT TEXT NOT NULL, FOREIGN KEY (RIDERID) REFERENCES rider(ID)) ");


    }



}
