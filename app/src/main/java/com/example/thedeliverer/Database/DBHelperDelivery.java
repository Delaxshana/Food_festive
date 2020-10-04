package com.example.thedeliverer.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class DBHelperDelivery extends SQLiteOpenHelper{

    public static final String DATABASE = "foodFestive.db";

 public DBHelperDelivery(Context context){
     super(context,DATABASE,null,1);
 }


    @Override
    public void onCreate(SQLiteDatabase db) {
     String SQL_CREATE_ENTRIES =
              "CREATE TABLE "+ UsersMasterDelivery.delivery.TABLE_NAME1 + "(" +
                      UsersMasterDelivery.delivery.COLUMN_NAME_RIDERID + "TEXT PRIMARY KEY," +
                      UsersMasterDelivery.delivery.COLUMN_NAME_RIDERNAME + "TEXT," +
                      UsersMasterDelivery.delivery.COLUMN_NAME_VEHICLENUM + "TEXT)";

     db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addRiderInfo(String ID, String name,String vehicleNum){
     SQLiteDatabase db = getWritableDatabase();

     ContentValues values = new ContentValues();
        values.put(UsersMasterDelivery.delivery.COLUMN_NAME_RIDERID, ID);
        values.put(UsersMasterDelivery.delivery.COLUMN_NAME_RIDERNAME, name);
        values.put(UsersMasterDelivery.delivery.COLUMN_NAME_VEHICLENUM, vehicleNum);

        long newRowId=db.insert(UsersMasterDelivery.delivery.TABLE_NAME1,null,values);
        return newRowId;
    }


}
