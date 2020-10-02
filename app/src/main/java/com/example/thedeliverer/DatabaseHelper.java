package com.example.thedeliverer;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "foodFestive.db";
    public static final String TABLE_USER = "user";
    public static final String USER_COL_1 = "ID";
    public static final String USER_COL_2 = "first name";
    public static final String USER_COL_3 = "last name";
    public static final String USER_COL_4 = "email";
    public static final String USER_COL_5 = "password";
    public static final String USER_COL_6 = "phone";

    public static final String TABLE_ITEM = "item";
    public static final String ITEM_COL_1 = "ID";
    public static final String ITEM_COL_2 = "item name";
    public static final String ITEM_COL_3 = "item type";
    public static final String ITEM_COL_4 = "item image";
    public static final String ITEM_COL_5 = "item price";
    public static final String ITEM_COL_6= "description";

    public static final String TABLE_ADDRESS = "address";
    public static final String ADDRESS_COL_1 = "email";
    public static final String ADDRESS_COL_2 = "door no";
    public static final String ADDRESS_COL_3 = "street no";
    public static final String ADDRESS_COL_4 = "city";
    public static final String ADDRESS_COL_5=  "note";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_USER + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, lNAME TEXT,EMAIL TEXT,PASSWORD TEXT,PHONE INTEGER)");
        db.execSQL("create table " + TABLE_ITEM + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, Image BLOB, DESCRIPTION TEXT,PRICE INTEGER)");
        db.execSQL("create table " + TABLE_ADDRESS + "(EMAIL TEXT ,DOOTNO TEXT, STREETNAME TEXT,CITY TEXT,NOTE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESS);
        onCreate(db);
    }

    public boolean insertItem(String name, String x,Integer id,String desc,String type){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            FileInputStream fs = new FileInputStream(x);
            byte[] imgbyte = new byte[fs.available()];
            fs.read(imgbyte);
            ContentValues contentValues = new ContentValues();
            contentValues.put("ID",id);
            contentValues.put("NAME",name);
            contentValues.put("TYPE",type);
            contentValues.put("IMAGE",imgbyte);
            contentValues.put("DESCRIPTION", desc);

            long result = db.insert(TABLE_USER, null,contentValues);
            fs.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean insertUserDetails(String fName,String lName,String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(USER_COL_2,fName);
        contentValues.put(USER_COL_3,lName);
        contentValues.put(USER_COL_4,email);
        contentValues.put(USER_COL_5,password);
        long result=db.insert(TABLE_USER,null,contentValues);
        if(result == -1){
            return false;
        }
        else return true;
}


    public boolean insertUserAddress(String doorNo,String streetNo,String city,String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        //contentValues.put(ADDRESS_COL_1,email);
        contentValues.put(ADDRESS_COL_2,doorNo);
        contentValues.put(ADDRESS_COL_3,streetNo);
        contentValues.put(ADDRESS_COL_4,city);
        contentValues.put(ADDRESS_COL_5,note);
        long result=db.insert(TABLE_ADDRESS,null,contentValues);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public boolean deleteItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            String name = item.getName();
            long result = db.delete(TABLE_ITEM, "id = ",new String[]{String.valueOf(name)});
            return true;
        }catch (SQLException e){
            return false;
        }
    }


}
