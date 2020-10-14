package com.example.thedeliverer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final String DATABASE_NAME = "foodFestive.db";
    public static final String TABLE_USER = "user";
    public static final String USER_COL_1 = "ID";
    public static final String USER_COL_2 = "firstname";
    public static final String USER_COL_3 = "lastname";
    public static final String USER_COL_4 = "email";
    public static final String USER_COL_5 = "password";
    public static final String USER_COL_6 = "phone";

    public static final String TABLE_ITEM = "item";
    public static final String ITEM_COL_1 = "ID";
    public static final String ITEM_COL_2 = "itemname";
    public static final String ITEM_COL_3 = "itemtype";
    //public static final String ITEM_COL_4 = "item image";
    public static final String ITEM_COL_5 = "itemprice";
    public static final String ITEM_COL_6= "description";

    public static final String TABLE_ADDRESS = "address";
    public static final String ADDRESS_COL_1 = "email";
    public static final String ADDRESS_COL_2 = "doorno";
    public static final String ADDRESS_COL_3 = "streetno";
    public static final String ADDRESS_COL_4 = "city";
    public static final String ADDRESS_COL_5=  "note";
    public static final String ADDRESS_COL_6=  "id";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 5);
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + TABLE_USER + " ( " +
                USER_COL_1 +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_COL_2 + " TEXT, " +
                USER_COL_3 + " TEXT, " +
                USER_COL_4 + " TEXT, " +
                USER_COL_5 + " TEXT, " +
                USER_COL_6 + " INTEGER) ");

        db.execSQL(" CREATE TABLE " + TABLE_ITEM + " ( " +
                ITEM_COL_1 +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ITEM_COL_2 + " TEXT, " +
                ITEM_COL_3 + " TEXT, " +
                ITEM_COL_5 + " TEXT, " +
                ITEM_COL_6 + " TEXT ) ");


        db.execSQL(" CREATE TABLE " + TABLE_ADDRESS + " ( " +
                ADDRESS_COL_6 +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
              //  ADDRESS_COL_1 + " TEXT, " +
                ADDRESS_COL_2 + " TEXT, " +
                ADDRESS_COL_3 + " TEXT, " +
                ADDRESS_COL_4 + " TEXT," +
                ADDRESS_COL_5 + " TEXT ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESS);
        onCreate(db);
    }

    public boolean insertItem(String name,String type,String price,String desc){
        SQLiteDatabase db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(ITEM_COL_2,name);
            contentValues.put(ITEM_COL_3,type);
            contentValues.put(ITEM_COL_5, price);
            contentValues.put(ITEM_COL_6, desc);
            long result = db.insert(TABLE_ITEM, null,contentValues);
            if(result == -1)
                return false;
            else return true;


    }

    public boolean insertUserDetails(String fName,String lName,String email,String password,String phoneNo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(USER_COL_2,fName);
        contentValues.put(USER_COL_3,lName);
        contentValues.put(USER_COL_4,email);
        contentValues.put(USER_COL_5,password);
        contentValues.put(USER_COL_6,phoneNo);
        long result=db.insert(TABLE_USER,null,contentValues);
        if(result == -1)
            return false;
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

    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_COL_2, user.getFname());
        values.put(USER_COL_3, user.getLname());
        values.put(USER_COL_4, user.getEmail());
        values.put(USER_COL_5, user.getPassword());
        values.put(USER_COL_6, user.getContactNo());

        db.update(TABLE_USER, values, USER_COL_1 + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }


    public boolean checkUser(String email, String password) {
        String[] columns = {
                USER_COL_1
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USER_COL_4 + " = ?" + " AND " + USER_COL_6 + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }


}
