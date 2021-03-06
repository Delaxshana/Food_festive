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

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "UserInfo.db";
    private static final String TAG = "DBHelper" ;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " ("+
                        UsersMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UsersMaster.Users.COLUMN_NAME_USERNAME + " TEXT,"+
                        UsersMaster.Users.COLUMN_NAME_PASSWORD +  " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);

        String SQL_CREATE_FOOD_CART_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users.CART_TABLE_NAME + " ("+
                        UsersMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UsersMaster.Users.COLUMN_NAME_ITEM + " TEXT,"+
                        UsersMaster.Users.COLUMN_NAME_QUANTITY + " TEXT,"+
                        UsersMaster.Users.COLUMN_NAME_SIZE + " TEXT)";

        db.execSQL(SQL_CREATE_FOOD_CART_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addInfo(String userName, String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_USERNAME,userName);
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,password);

        long newRowId = db.insert(UsersMaster.Users.TABLE_NAME,null,values);
        return newRowId;
    }

    public long addCartTableInfo(String item, String quantity, String size){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_ITEM,item);
        values.put(UsersMaster.Users.COLUMN_NAME_QUANTITY,quantity);
        values.put(UsersMaster.Users.COLUMN_NAME_SIZE,size);

        long newRowId = db.insert(UsersMaster.Users.CART_TABLE_NAME,null,values);
        return newRowId;
    }

    public List readAllInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMaster.Users._ID,
                UsersMaster.Users.COLUMN_NAME_USERNAME,
                UsersMaster.Users.COLUMN_NAME_PASSWORD
        };

        String sortOrder = UsersMaster.Users.COLUMN_NAME_USERNAME + " DESC";

        Cursor cursor = db.query(
                UsersMaster.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List userNames = new ArrayList<>();
        List passwords = new ArrayList<>();

        while (cursor.moveToNext()){
            String username = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_USERNAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));
            userNames.add(username);
            passwords.add(password);
        }
        cursor.close();
        Log.i(TAG,"readAllInfo: " + userNames);

        if (req=="user"){
            return userNames;
        }else if (req=="password"){
            return passwords;
        }else {
            return null;
        }

    }

    public Map<String, String> readAllcartsInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMaster.Users._ID,
                UsersMaster.Users.COLUMN_NAME_ITEM,
                UsersMaster.Users.COLUMN_NAME_QUANTITY,
                UsersMaster.Users.COLUMN_NAME_SIZE
        };

        String sortOrder = UsersMaster.Users.COLUMN_NAME_ITEM + " DESC";
        Cursor cursor = db.query(
                UsersMaster.Users.CART_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        Map<String,String> items_quantities = new HashMap<String,String>();
        Map<String,String> items_sizes = new HashMap<String,String>();

//        List userNames = new ArrayList<>();
//        List passwords = new ArrayList<>();

        while (cursor.moveToNext()){
            String item_name = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_ITEM));
            String item_quantity = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_QUANTITY));
            String item_size = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_SIZE));
            items_quantities.put(item_name,item_quantity);
            items_sizes.put(item_name,item_size);
        }
        cursor.close();
        Log.i(TAG,"readAllcartsInfo: " + items_quantities);

        if (req=="items_and_quantities"){
            return items_quantities;
        }else if (req=="items_and_sizes"){
            return items_sizes;
        }else {
            return null;
        }

    }

    public void deleteInfo(String userName){
        SQLiteDatabase db = getReadableDatabase();

        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = { userName };
        db.delete(UsersMaster.Users.TABLE_NAME,selection,selectionArgs);
    }

    public void deleteCartInfo(String item){
        SQLiteDatabase db = getReadableDatabase();

        String selection = UsersMaster.Users.COLUMN_NAME_ITEM + " LIKE ?";
        String[] selectionArgs = { item };
        db.delete(UsersMaster.Users.CART_TABLE_NAME,selection,selectionArgs);
    }

    public int updateInfo(String userName, String password){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,password);

        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = { userName };

        int count = db.update(
                UsersMaster.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        return count;
    }

    public int updateCartInfo(String item, String quantity,String size){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_QUANTITY,quantity);
        values.put(UsersMaster.Users.COLUMN_NAME_SIZE,size);

        String selection = UsersMaster.Users.COLUMN_NAME_ITEM + " LIKE ?";
        String[] selectionArgs = { item };

        int count = db.update(
                UsersMaster.Users.CART_TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        return count;
    }


}
