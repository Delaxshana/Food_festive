package com.example.thedeliverer.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBHelperDelivery extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "foodFestive.db";
    public static final String TABLE_NAME1= "rider";
    public static final String TABLE1_COLUMN_1= "ID";
    public static final String TABLE1_COLUMN_2= "Name";
    public static final String TABLE1_COLUMN_3= "Contact";
    public static final String TABLE1_COLUMN_4= "VehicleNum";

    public static final String TABLE_NAME2= "delivery";
    public static final String TABLE2_COLUMN_1= "ID";
    public static final String TABLE2_COLUMN_2= "RiderID";
    public static final String TABLE2_COLUMN_3= "RiderName";
    public static final String TABLE2_COLUMN_4= "Contact";



    public DBHelperDelivery(Context context){
        super(context,DATABASE_NAME,null,1);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  " + TABLE_NAME1 + " (ID TEXT PRIMARY KEY, NAME TEXT, CONTACT INTEGER, VEHICLE TEXT) ");
        db.execSQL("CREATE TABLE  " + TABLE_NAME2 + " (ID TEXT PRIMARY KEY, RIDERID TEXT, NAME TEXT, CONTACT INTEGER) ");

    }

    public boolean insertRider(String ID,String name,String Contact,String Vehicle){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE1_COLUMN_1,ID);
        values.put(TABLE1_COLUMN_2,name);
        values.put(TABLE1_COLUMN_3,Contact);
        values.put(TABLE1_COLUMN_4,Vehicle);

        long result = db.insert(TABLE_NAME1,null,values);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public boolean insertDelivery(String ID,String riderID,String name,String contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE1_COLUMN_1,ID);
        values.put(TABLE1_COLUMN_2,riderID);
        values.put(TABLE1_COLUMN_3,name);
        values.put(TABLE1_COLUMN_4,contact);

        long result = db.insert(TABLE_NAME2,null,values);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public Cursor getDeliveryData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;
    }

    public void deleteDeliveryInfo(String item){
        SQLiteDatabase db = getReadableDatabase();

        String selection = TABLE2_COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { item };
        db.delete(TABLE_NAME2,selection,selectionArgs);
    }

    public int updateDeliveryInfo(String riderID, String riderName,String contact){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE2_COLUMN_2,riderID);
        values.put(TABLE2_COLUMN_3,riderName);
        values.put(TABLE2_COLUMN_4,contact);


        String selection = TABLE2_COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { riderID };

        int count = db.update(
                TABLE_NAME2,
                values,
                selection,
                selectionArgs
        );

        return count;
    }


}
