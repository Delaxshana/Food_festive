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

     DatabaseHelper dbHelper;
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

                Item item=new Item();

                item.id = id;
                item.name = itemname;
                item.description = itemdesc;
                item.price = itemprice;
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

        String sortOrder =
                ITEM_COL_1 + " ASC";
        List<Item> ItemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ITEM,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

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
    public boolean updateItem(String itemName,String itemDesc,String itemPrice){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(ITEM_COL_1,id);
        values.put(ITEM_COL_2,itemName);
        values.put(ITEM_COL_5,itemPrice);
        values.put(ITEM_COL_6,itemDesc);
        db.update(TABLE_ITEM,values,"name = ?",new String[]  { itemName });

        return true;

    }

    public Item getspecificItem(String id) {
        String idItem=id;
        String[] columns = {
                ITEM_COL_1,
                ITEM_COL_2,
                ITEM_COL_3,
                ITEM_COL_5,
                ITEM_COL_6
        };

        String sortOrder =
                ITEM_COL_1 + " ASC";

        Item i=new Item();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM item where id=?", new String[]{idItem});



        if (cursor.moveToFirst()) {
            do {
                i = new Item();
                i.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ITEM_COL_1))));
                i.setName(cursor.getString(cursor.getColumnIndex(ITEM_COL_2)));
                i.setType(cursor.getString(cursor.getColumnIndex(ITEM_COL_3)));


            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return i;
    }
}
