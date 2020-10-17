package com.example.thedeliverer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserControl extends DatabaseHelper{

    public UserControl(@Nullable Context context) {
        super(context);
        DatabaseHelper dbHelper;
        SQLiteDatabase db;
    }

    public User getSpecificUser(String idIn) {

        String userid = idIn;
        String sql = "SELECT * FROM user WHERE ID =" + userid;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        User user = null;
        if (cursor.moveToFirst()) {

            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("USER_COL_1")));
                String username = cursor.getString(cursor.getColumnIndex("USER_COL_2"));
                String email = cursor.getString(cursor.getColumnIndex("USER_COL_4"));
                String phone = cursor.getString(cursor.getColumnIndex("USER_COL_6"));

                user = new User();
                user.id = id;
                user.fname = username;
                user.email = email;
                user.phone = phone;

            } while (cursor.moveToNext());

        }

        cursor.close();
        db.close();
        return user;

    }

}
