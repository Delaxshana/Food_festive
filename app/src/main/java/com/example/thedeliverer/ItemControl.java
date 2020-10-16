package com.example.thedeliverer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.thedeliverer.Database.DBHelperDelivery;
import com.example.thedeliverer.Database.ObjectDelivery;

import java.util.ArrayList;
import java.util.List;

public class ItemControl extends DatabaseHelper{


    public ItemControl(@Nullable Context context) {
        super(context);
    }
    DBHelperDelivery dbHelper;
    SQLiteDatabase db;

    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM item";

        int recordCount = db.rawQuery(sql, null).getCount();

        db.close();

        return recordCount;

    }

    public List<Item> read() {

        List<Item> recordsList = new ArrayList<Item>();

        String sql = "SELECT * FROM item ORDER BY ID DESC";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("ITEM_COL_1")));
                String itemname = cursor.getString(cursor.getColumnIndex("ITEM_COL_2"));
                String itemprice = cursor.getString(cursor.getColumnIndex("ITEM_COL_5"));
                String itemdesc = cursor.getString(cursor.getColumnIndex("ITEM_COL_6"));

                //Initializing delivery object with read values from database
                Item item=new Item();

                item.id = id;
                item.description = itemdesc;
                item.price = itemprice;
                item.name = itemname;

                recordsList.add(item);

            } while (cursor.moveToNext());

        }

        cursor.close();
        db.close();
        return recordsList;

    }



    public List<Item> getAllItem() {
        // array of columns to fetch
        String[] columns = {
                ITEM_COL_1,
                ITEM_COL_2,
                ITEM_COL_3,
                ITEM_COL_5,
                ITEM_COL_6
        };
        // sorting orders
        String sortOrder =
                ITEM_COL_1 + " ASC";
        List<Item> ItemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_ITEM, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ITEM_COL_1))));
                item.setName(cursor.getString(cursor.getColumnIndex(ITEM_COL_2)));
                item.setType(cursor.getString(cursor.getColumnIndex(ITEM_COL_3)));

                ItemList.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return ItemList;
    }

    public boolean delete(int id) {

        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();

        deleteSuccessful = db.delete("item", "ID ='" + id + "'", null) > 0;

        db.close();

        return deleteSuccessful;

    }
}
