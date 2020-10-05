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

    public DBHelperDelivery(Context context){
        super(context,DATABASE_NAME,null,1);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  " + TABLE_NAME1 + " (ID TEXT PRIMARY KEY, NAME TEXT, CONTACT INTEGER, VEHICLE TEXT) ");

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
}
