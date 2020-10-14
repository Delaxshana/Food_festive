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
import java.util.Random;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "UserInfo.db";
    private static final String TAG = "DBHelper" ;



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String SQL_CREATE_ENTRIES =
//                "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " ("+
//                        UsersMaster.Users._ID + " INTEGER PRIMARY KEY," +
//                        UsersMaster.Users.COLUMN_NAME_USERNAME + " TEXT,"+
//                        UsersMaster.Users.COLUMN_NAME_PASSWORD +  " TEXT)";
//
//        db.execSQL(SQL_CREATE_ENTRIES);
//        db.execSQL("delete from " + UsersMaster.Users.CART_TABLE_NAME);
//        db.delete(UsersMaster.Users.CART_TABLE_NAME,null,null);

//        String SQL_CREATE_FOOD_CART_ENTRIES =
//                "CREATE TABLE " + UsersMaster.Users.CART_TABLE_NAME + " ("+
//                        UsersMaster.Users._ID + "INTEGER PRIMARY KEY," +
//                        UsersMaster.Users.COLUMN_NAME_CARTID + " TEXT," +
//                        UsersMaster.Users.COLUMN_NAME_ITEM + " TEXT,"+
//                        UsersMaster.Users.COLUMN_NAME_QUANTITY + " TEXT,"+
//                        UsersMaster.Users.COLUMN_NAME_SIZE + " TEXT)";
//
//        db.execSQL(SQL_CREATE_FOOD_CART_ENTRIES);

        String SQL_CREATE_FOOD_CART_ENTRIES =
                "CREATE TABLE " + UsersMaster.Cart.CART_TABLE_NAME + " ("+
                        UsersMaster.Cart.CART_ID + " INTEGER PRIMARY KEY," +
//                        UsersMaster.Cart.CART_TABLE_ID + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_ITEM1 + " TEXT," +
                        UsersMaster.Cart.COLUMN_NAME_ITEM2 + " TEXT," +
                        UsersMaster.Cart.COLUMN_NAME_ITEM3 + " TEXT," +
                        UsersMaster.Cart.COLUMN_NAME_ITEM4 + " TEXT," +
                        UsersMaster.Cart.COLUMN_NAME_QUANTITY1 + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_QUANTITY2 + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_QUANTITY3 + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_QUANTITY4 + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_SIZE1 + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_SIZE2 + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_SIZE3 + " TEXT,"+
                        UsersMaster.Cart.COLUMN_NAME_SIZE4 + " TEXT)";

        db.execSQL(SQL_CREATE_FOOD_CART_ENTRIES);

        String SQL_CREATE_ORDER_ENTRIES =
                "CREATE TABLE " + UsersMaster.Order.ORDER_TABLE_NAME + " ("+
                        UsersMaster.Order.ORDER_TABLE_ID + " INTEGER PRIMARY KEY," +
                        UsersMaster.Order.CART_TABLE_ID + " TEXT,"+
                        UsersMaster.Order.COLUMN_NAME_EXTRA + " TEXT,"+
                        UsersMaster.Order.COLUMN_NAME_DATE + " TEXT,"+
                        UsersMaster.Order.COLUMN_NAME_TIME + " TEXT)";

        db.execSQL(SQL_CREATE_ORDER_ENTRIES);

        String SQL_CREATE_CART_ROW_ENTRIES =
                "CREATE TABLE " + UsersMaster.Cart_row.CART_ROW_TABLE_NAME + " ("+
                        UsersMaster.Cart_row.CART_ROW_ID + " INTEGER PRIMARY KEY," +
                        UsersMaster.Cart_row.COLUMN_NAME_ITEM + " TEXT,"+
                        UsersMaster.Cart_row.COLUMN_NAME_QUANTITY + " TEXT,"+
                        UsersMaster.Cart_row.COLUMN_NAME_SIZE + " TEXT)";

        db.execSQL(SQL_CREATE_CART_ROW_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UsersMaster.Cart.CART_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UsersMaster.Order.ORDER_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UsersMaster.Cart_row.CART_ROW_TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    public long addInfo(String userName, String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_USERNAME,userName);
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,password);

        long newRowId = db.insert(UsersMaster.Users.TABLE_NAME,null,values);
        return newRowId;
    }

    public String addCartTableInfo(String item1,String item2,String item3,String item4, String quantity1, String quantity2, String quantity3,String quantity4, String size1,String size2,String size3,String size4){
        SQLiteDatabase db = getWritableDatabase();
//        ij++;

//        String cartID = generateCartIDs(readAllcartsInfo("carts_ID"));
//        String cartID = "C000" + ij;


        ContentValues values = new ContentValues();
//        values.put(UsersMaster.Cart.CART_TABLE_ID,cartID);
        values.put(UsersMaster.Cart.COLUMN_NAME_ITEM1,item1);
        values.put(UsersMaster.Cart.COLUMN_NAME_ITEM2,item2);
        values.put(UsersMaster.Cart.COLUMN_NAME_ITEM3,item3);
        values.put(UsersMaster.Cart.COLUMN_NAME_ITEM4,item4);
        values.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY1,quantity1);
        values.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY2,quantity2);
        values.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY3,quantity3);
        values.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY4,quantity4);
        values.put(UsersMaster.Cart.COLUMN_NAME_SIZE1,size1);
        values.put(UsersMaster.Cart.COLUMN_NAME_SIZE2,size2);
        values.put(UsersMaster.Cart.COLUMN_NAME_SIZE3,size3);
        values.put(UsersMaster.Cart.COLUMN_NAME_SIZE4,size4);

//        String cartID = generateCartIDs();
//        values.put(UsersMaster.Users.COLUMN_NAME_CARTID,cartID);

        long newRowId = db.insert(UsersMaster.Cart.CART_TABLE_NAME,null,values);
        String cartID = readAllcartsInfo("cart_ID");
        if (newRowId>0){
            return cartID;
        }
        else{
            return null;
        }
        //String idcart = Long.toString(newRowId);
//        return  newRowId;
    }

//    public List getCartIds(){
//        SQLiteDatabase db = getReadableDatabase();
//
//        String[] projection = {
//                UsersMaster.Users._ID,
//                UsersMaster.Users.COLUMN_NAME_CARTID,
//                UsersMaster.Users.COLUMN_NAME_ITEM,
//                UsersMaster.Users.COLUMN_NAME_QUANTITY,
//                UsersMaster.Users.COLUMN_NAME_SIZE
//        };
//
//        String sortOrder = UsersMaster.Users.COLUMN_NAME_ITEM + " DESC";
//
//        Cursor cursor = db.query(
//                UsersMaster.Cart.CART_TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                sortOrder
//        );
//
//        List cartIds = new ArrayList<String>();
////        List passwords = new ArrayList<>();
//
//        while (cursor.moveToNext()){
//            String cart_Id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users._ID));
////            int item_ID = Integer.parseInt(item_Id);
//            cartIds.add(cart_Id);
//        }
//        cursor.close();
//        Log.i(TAG,"getCartIds: " + cartIds);
//
//        boolean number = cartIds.isEmpty();
//        if (number==true){
//            cartIds.add("cartid");
//        }
//
//        return cartIds;
//    }

    public String addOrderTableInfo(String cart_id,String extra,String date, String time){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Order.CART_TABLE_ID,cart_id);
        values.put(UsersMaster.Order.COLUMN_NAME_EXTRA,extra);
        values.put(UsersMaster.Order.COLUMN_NAME_DATE,date);
        values.put(UsersMaster.Order.COLUMN_NAME_TIME,time);

        long newRowId = db.insert(UsersMaster.Order.ORDER_TABLE_NAME,null,values);
        String orderID = readAllOrderInfo("order_ID");
        if (newRowId>0){
            return orderID;
        }
        else{
            return null;
        }
//        String orderID = readAllOrderInfo("order_ID");
//        if (newRowId>0){
//            return orderID;
//        }
//        else{
//            return null;
//        }
//        return  newRowId;
    }

    public String addCartRowTableInfo(String item,String quantity,String size){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Cart_row.COLUMN_NAME_ITEM,item);
        values.put(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY,quantity);
        values.put(UsersMaster.Cart_row.COLUMN_NAME_SIZE,size);

        long newRowId = db.insert(UsersMaster.Cart_row.CART_ROW_TABLE_NAME,null,values);
        String cartRowID = readAllCartRowInfo("spc_carts_ID");
        if (newRowId>0){
            return cartRowID;
        }
        else{
            return null;
        }
//        return  newRowId;
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

    public String readAllcartsInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMaster.Cart.CART_ID,
//                UsersMaster.Cart.CART_TABLE_ID,
                UsersMaster.Cart.COLUMN_NAME_ITEM1,
                UsersMaster.Cart.COLUMN_NAME_ITEM2,
                UsersMaster.Cart.COLUMN_NAME_ITEM3,
                UsersMaster.Cart.COLUMN_NAME_ITEM4,
                UsersMaster.Cart.COLUMN_NAME_QUANTITY1,
                UsersMaster.Cart.COLUMN_NAME_QUANTITY2,
                UsersMaster.Cart.COLUMN_NAME_QUANTITY3,
                UsersMaster.Cart.COLUMN_NAME_QUANTITY4,
                UsersMaster.Cart.COLUMN_NAME_SIZE1,
                UsersMaster.Cart.COLUMN_NAME_SIZE2,
                UsersMaster.Cart.COLUMN_NAME_SIZE3,
                UsersMaster.Cart.COLUMN_NAME_SIZE4
        };

        String sortOrder = UsersMaster.Cart.COLUMN_NAME_ITEM1 + " DESC";

        Cursor cursor = db.query(
                UsersMaster.Cart.CART_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
//        Map<String,String> items_names = new HashMap<>();
        String cart_id = null;
//        String cartId = null;
        String item1 = null;
        String item2 = null;
        String item3 = null;
        String item4 = null;
        String quantity1 = null;
        String quantity2 = null;
        String quantity3 = null;
        String quantity4 = null;
        String size1 = null;
        String size2 = null;
        String size3 = null;
        String size4 = null;
//        Map<String,String> items_quantities = new HashMap<String,String>();
//        Map<String,String> items_sizes = new HashMap<String,String>();
//        Map<String,String> items_Ids = new HashMap<>();

//        List userNames = new ArrayList<>();
//        List passwords = new ArrayList<>();

        while (cursor.moveToNext()){
            cart_id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.CART_ID));
//            cartId = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.CART_TABLE_ID));
            item1 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_ITEM1));
            item2 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_ITEM2));
            item3 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_ITEM3));
            item4 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_ITEM4));
            quantity1 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_QUANTITY1));
            quantity2 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_QUANTITY2));
            quantity3 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_QUANTITY3));
            quantity4 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_QUANTITY4));
            size1 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_SIZE1));
            size2 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_SIZE2));
            size3 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_SIZE3));
            size4 = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_SIZE4));

//            String item_quantity = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_QUANTITY));
//            String item_size = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_SIZE));
//            String item_Id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_CARTID));
//            int item_ID = Integer.parseInt(item_Id);
//            items_Ids.put(item_Id,item_name);
//            items_names.put(item_Id,item_name);
//            items_quantities.put(item_Id,item_quantity);
//            items_sizes.put(item_Id,item_size);
        }
        cursor.close();
//        Log.i(TAG,"readAllcartsInfo: " + cartId);
//        Log.i(TAG,"readAllcartsInfo: " + item1);
//        Log.i(TAG,"readAllcartsInfo: " + item2);
//        Log.i(TAG,"readAllcartsInfo: " + item3);
//        Log.i(TAG,"readAllcartsInfo: " + item4);
//        Log.i(TAG,"readAllcartsInfo: " + quantity1);
//        Log.i(TAG,"readAllcartsInfo: " + quantity2);
//        Log.i(TAG,"readAllcartsInfo: " + quantity3);
//        Log.i(TAG,"readAllcartsInfo: " + quantity4);
//        Log.i(TAG,"readAllcartsInfo: " + size1);
//        Log.i(TAG,"readAllcartsInfo: " + size2);
//        Log.i(TAG,"readAllcartsInfo: " + size3);
//        Log.i(TAG,"readAllcartsInfo: " + size4);
//        Log.i(TAG,"readAllcartsInfo: " + items_quantities);
//        Log.i(TAG,"readAllcartsInfo: " + items_sizes);

//        if (req=="items_and_quantities"){
////            return items_quantities;
//        }else if (req=="items_and_sizes") {
////            return items_sizes;
        if (req=="cart_ID") {
            return cart_id;
//        }else if (req=="carts_ID"){
//            return cartId;
        }else if (req=="item1"){
            return item1;
        }else if (req=="item2"){
            return item2;
        }else if (req=="item3"){
            return item3;
        }else if (req=="item4"){
            return item4;
        }else if (req=="quantity1"){
            return quantity1;
        }else if (req=="quantity2"){
            return quantity2;
        }else if (req=="quantity3"){
            return quantity3;
        }else if (req=="quantity4"){
            return quantity4;
        }else if (req=="size1"){
            return size1;
        }else if (req=="size2"){
            return size2;
        }else if (req=="size3"){
            return size3;
        }else if (req=="size4"){
            return size4;
        }else {
            return null;
        }

    }

    public String readAllOrderInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMaster.Order.ORDER_TABLE_ID,
                UsersMaster.Order.CART_TABLE_ID,
                UsersMaster.Order.COLUMN_NAME_EXTRA,
                UsersMaster.Order.COLUMN_NAME_DATE,
                UsersMaster.Order.COLUMN_NAME_TIME
        };

        String sortOrder = UsersMaster.Order.ORDER_TABLE_ID + " DESC";

        Cursor cursor = db.query(
                UsersMaster.Order.ORDER_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
//        Map<String,String> items_names = new HashMap<>();
        String cartid = null;
        String order_id = null;
        String extra = null;
        String date = null;
        String time = null;
//        Map<String,String> items_quantities = new HashMap<String,String>();
//        Map<String,String> items_sizes = new HashMap<String,String>();
//        Map<String,String> items_Ids = new HashMap<>();

//        List userNames = new ArrayList<>();
//        List passwords = new ArrayList<>();

//        while (cursor.moveToNext()){
//            order_id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Order.ORDER_TABLE_ID));
//            cartid = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Order.CART_TABLE_ID));
//            extra = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Order.COLUMN_NAME_EXTRA));
//            date = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Order.COLUMN_NAME_DATE));
//            time = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Order.COLUMN_NAME_TIME));
//
////            String item_quantity = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_QUANTITY));
////            String item_size = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_SIZE));
////            String item_Id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_CARTID));
////            int item_ID = Integer.parseInt(item_Id);
////            items_Ids.put(item_Id,item_name);
////            items_names.put(item_Id,item_name);
////            items_quantities.put(item_Id,item_quantity);
////            items_sizes.put(item_Id,item_size);
//        }
//        cursor.close();
        if(cursor != null)
        {
            if (cursor.moveToFirst()) {
                order_id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Order.ORDER_TABLE_ID));
            }
            cursor.close();
        }

        db.close();
//        Log.i(TAG,"readAllcartsInfo: " + cartId);
//        Log.i(TAG,"readAllcartsInfo: " + item1);
//        Log.i(TAG,"readAllcartsInfo: " + item2);
//        Log.i(TAG,"readAllcartsInfo: " + item3);
//        Log.i(TAG,"readAllcartsInfo: " + item4);
//        Log.i(TAG,"readAllcartsInfo: " + quantity1);
//        Log.i(TAG,"readAllcartsInfo: " + quantity2);
//        Log.i(TAG,"readAllcartsInfo: " + quantity3);
//        Log.i(TAG,"readAllcartsInfo: " + quantity4);
//        Log.i(TAG,"readAllcartsInfo: " + size1);
//        Log.i(TAG,"readAllcartsInfo: " + size2);
//        Log.i(TAG,"readAllcartsInfo: " + size3);
//        Log.i(TAG,"readAllcartsInfo: " + size4);
//        Log.i(TAG,"readAllcartsInfo: " + items_quantities);
//        Log.i(TAG,"readAllcartsInfo: " + items_sizes);

//        if (req=="items_and_quantities"){
////            return items_quantities;
//        }else if (req=="items_and_sizes") {
////            return items_sizes;
        if (req=="order_ID") {
            return order_id;
//        }else if (req=="carts_ID"){
//            return cartId;
        }else if (req=="cart_ID"){
            return cartid;
        }else if (req=="extra"){
            return extra;
        }else if (req=="date"){
            return date;
        }else if (req=="time"){
            return time;
        }else {
            return null;
        }

    }

    public String readAllCartRowInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMaster.Cart_row.CART_ROW_ID,
                UsersMaster.Cart_row.COLUMN_NAME_ITEM,
                UsersMaster.Cart_row.COLUMN_NAME_QUANTITY,
                UsersMaster.Cart_row.COLUMN_NAME_SIZE
        };

        String sortOrder = UsersMaster.Cart_row.CART_ROW_ID + " DESC";

        Cursor cursor = db.query(
                UsersMaster.Cart_row.CART_ROW_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
//        Map<String,String> items_names = new HashMap<>();
        String spcCartRow = null;
        String cartrowid = null;
        String item = null;
        String quantity = null;
        String size = null;
//        Map<String,String> items_quantities = new HashMap<String,String>();
//        Map<String,String> items_sizes = new HashMap<String,String>();
//        Map<String,String> items_Ids = new HashMap<>();

//        List userNames = new ArrayList<>();
//        List passwords = new ArrayList<>();

//        while (cursor.moveToNext()){
////            if(cursor.moveToFirst()){
////                spcCartRow = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart_row.CART_ROW_ID));
////            }
//            cartrowid = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart_row.CART_ROW_ID));
//            item = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart_row.COLUMN_NAME_ITEM));
//            quantity = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY));
//            size = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart_row.COLUMN_NAME_SIZE));
////
////            if(cursor.moveToFirst()){
////                spcCartRow = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart_row.CART_ROW_ID));
////            }
//
////            String item_quantity = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_QUANTITY));
////            String item_size = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_SIZE));
////            String item_Id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart.COLUMN_NAME_CARTID));
////            int item_ID = Integer.parseInt(item_Id);
////            items_Ids.put(item_Id,item_name);
////            items_names.put(item_Id,item_name);
////            items_quantities.put(item_Id,item_quantity);
////            items_sizes.put(item_Id,item_size);
//        }
//        cursor.close();

        if(cursor != null)
        {
            if (cursor.moveToFirst()) {
                spcCartRow = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Cart_row.CART_ROW_ID));
            }
            cursor.close();
        }

        db.close();



//        if (req=="items_and_quantities"){
////            return items_quantities;
//        }else if (req=="items_and_sizes") {
////            return items_sizes;
        if (req=="cart_row_ID") {
            return cartrowid;
        }else if (req=="spc_carts_ID"){
            return spcCartRow;
        }else if (req=="item_name"){
            return item;
        }else if (req=="item_quantity"){
            return quantity;
        }else if (req=="item_size"){
            return size;
        }else {
            return null;
        }

    }

//    public Map<String, String> readAllcartsInfoQ(String req){
//        SQLiteDatabase db = getReadableDatabase();
//
//        String[] projection = {
//                UsersMaster.Users._ID,
//                UsersMaster.Users.COLUMN_NAME_CARTID,
//                UsersMaster.Users.COLUMN_NAME_ITEM,
//                UsersMaster.Users.COLUMN_NAME_QUANTITY,
//                UsersMaster.Users.COLUMN_NAME_SIZE
//        };
//
//        String sortOrder = UsersMaster.Users.COLUMN_NAME_CARTID + " DESC";
//
//        Cursor cursor = db.query(
//                UsersMaster.Users.CART_TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                sortOrder
//        );
////        Map<String,String> items_names = new HashMap<>();
//        Map<String,String> items_quantities = new HashMap<String,String>();
////        Map<String,String> items_sizes = new HashMap<String,String>();
////        Map<String,String> items_Ids = new HashMap<>();
//
////        List userNames = new ArrayList<>();
////        List passwords = new ArrayList<>();
//
//        while (cursor.moveToNext()){
//
////            String item_name = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_ITEM));
//            String item_quantity = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_QUANTITY));
////            String item_size = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_SIZE));
//            String item_Id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_CARTID));
////            int item_ID = Integer.parseInt(item_Id);
////            items_Ids.put(item_Id,item_name);
////            items_names.put(item_Id,item_name);
//            items_quantities.put(item_Id,item_quantity);
////            items_sizes.put(item_Id,item_size);
//        }
//        cursor.close();
////        Log.i(TAG,"readAllcartsInfo: " + items_names);
//        Log.i(TAG,"readAllcartsInfo: " + items_quantities);
////        Log.i(TAG,"readAllcartsInfo: " + items_sizes);
//
//        if (req=="items_and_quantities"){
//            return items_quantities;
////        }else if (req=="items_and_sizes") {
//////            return items_sizes;
////        }else if (req=="items_names"){
//////            return items_names;
//        }else {
//            return null;
//        }
//
//    }
//
//    public Map<String, String> readAllcartsInfoSize(String req){
//        SQLiteDatabase db = getReadableDatabase();
//
//        String[] projection = {
//                UsersMaster.Users._ID,
//                UsersMaster.Users.COLUMN_NAME_CARTID,
//                UsersMaster.Users.COLUMN_NAME_ITEM,
//                UsersMaster.Users.COLUMN_NAME_QUANTITY,
//                UsersMaster.Users.COLUMN_NAME_SIZE
//        };
//
//        String sortOrder = UsersMaster.Users.COLUMN_NAME_CARTID + " DESC";
//
//        Cursor cursor = db.query(
//                UsersMaster.Users.CART_TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                sortOrder
//        );
////        Map<String,String> items_names = new HashMap<>();
////        Map<String,String> items_quantities = new HashMap<String,String>();
//        Map<String,String> items_sizes = new HashMap<String,String>();
////        Map<String,String> items_Ids = new HashMap<>();
//
////        List userNames = new ArrayList<>();
////        List passwords = new ArrayList<>();
//
//        while (cursor.moveToNext()){
//
////            String item_name = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_ITEM));
////            String item_quantity = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_QUANTITY));
//            String item_size = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_SIZE));
//            String item_Id = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_CARTID));
////            int item_ID = Integer.parseInt(item_Id);
////            items_Ids.put(item_Id,item_name);
////            items_names.put(item_Id,item_name);
////            items_quantities.put(item_Id,item_quantity);
//            items_sizes.put(item_Id,item_size);
//        }
//        cursor.close();
////        Log.i(TAG,"readAllcartsInfo: " + items_names);
////        Log.i(TAG,"readAllcartsInfo: " + items_quantities);
//        Log.i(TAG,"readAllcartsInfo: " + items_sizes);
//
////        if (req=="items_and_quantities"){
//////            return items_quantities;
//        if (req=="items_and_sizes") {
//            return items_sizes;
////        }else if (req=="items_names"){
//////            return items_names;
//        }else {
//            return null;
//        }
//
//    }

//    public String generateCartIDs(String cartid) {
//
////        Random rand = new Random();
////        int nextId = rand.nextInt(1000);
//        boolean ans = cartid.isEmpty();
//        int nextId = 0;
//        if (cartid == null || ans==true){
//            nextId = 1;
//        }
//        else {
//            nextId++;
//        }
//
//        String cartId;
////        int nextId = arrayList.size();
//
//        cartId = "C000" + nextId;
//        if (cartid == cartId) {
//            nextId++;
//            cartId = "C000" + nextId;
//        }
//        return cartId;
//    }

//    public String generateCartIDs() {
//
//        Random rand = new Random();
//        int nextId = rand.nextInt(1000);
////        if (ans==true){
////            nextId = 1;
////        }
////        else {
////            nextId = arrayList.size();
////            nextId++;
////        }
//
//        String cartId;
////        int nextId = arrayList.size();
//
//        cartId = "C000" + nextId;
////        if (arrayList.contains(cartId)) {
////            nextId++;
////            cartId = "C000" + nextId;
////        }
//        return cartId;
//    }

    public void deleteInfo(String userName){
        SQLiteDatabase db = getReadableDatabase();

        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = { userName };
        db.delete(UsersMaster.Users.TABLE_NAME,selection,selectionArgs);
    }

    public void deleteCartInfo(int cartRowId){
        SQLiteDatabase db = this.getWritableDatabase();

//        String cartrowid = Integer.toString(cartRowId);

        db.execSQL("delete from "+UsersMaster.Cart_row.CART_ROW_TABLE_NAME+" where "+UsersMaster.Cart_row.CART_ROW_ID+"="+cartRowId);

//        String selection = UsersMaster.Cart_row.CART_ROW_ID + " LIKE ?";
//        String[] selectionArgs = { cartrowid };
//        db.delete(UsersMaster.Cart_row.CART_ROW_TABLE_NAME,selection, selectionArgs);


//        int number =  db.delete(UsersMaster.Cart_row.CART_ROW_TABLE_NAME,
//                UsersMaster.Cart_row.CART_ROW_ID+" = ? ", new String[] { Integer.toString(cartRowId) });
//
//
//        return number;

//        String selection = UsersMaster.Cart_row.CART_ROW_ID + " LIKE ?"
//        String item1,item2,item3,item4,quantity1,quantity2,quantity3,quantity4,size2,size3,size4,size1;
//        item1 = item2 = item3 = item4 = quantity1 = quantity2 = quantity3 = quantity4 = size1 = size2 = size3 = size4 = null;
//
//        Cursor res =  db.rawQuery( "select * from "+UsersMaster.Cart.CART_TABLE_NAME+" where "+UsersMaster.Cart.CART_ID+"="+cartID+"", null );
//        res.moveToFirst();
//
//
//
//        if (cart_size>0){
//             item1 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM1));
//             quantity1 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY1));
//             size1 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE1));
//
//            if (cart_size>1){
//                item2 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM2));
//                quantity2 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY2));
//                size2 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE2));
//
//                if (cart_size>2){
//                    item3 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM3));
//                    quantity3 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY3));
//                    size3 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE3));
//
//                    if (cart_size>3){
//                        item4 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM4));
//                        quantity4 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY4));
//                        size4 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE4));
//
//                    }
//                }
//            }
//        }
//
//        if (!res.isClosed())  {
//            res.close();
//        }
//
//        ContentValues contentValues = new ContentValues();
//
//        if (item1 == item && quantity1 ==quantity && size1 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM1,"item");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY1,"1");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE1,"small");
//
//        }
//
//        else if (item2 == item && quantity2 ==quantity && size2 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM2,"item");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY2,"1");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE2,"small");
//        }
//
//        else if (item3 == item && quantity3 ==quantity && size3 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM3,"item");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY3,"1");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE3,"small");
//        }
//
//        else if (item4 == item && quantity4 ==quantity && size4 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM4,"item");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY4,"1");
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE4,"small");
//        }
//
//
//
//
//
//        db.update(UsersMaster.Cart.CART_TABLE_NAME, contentValues, UsersMaster.Cart.CART_ID+" = ? ", new String[] { Integer.toString(cartID) } );
//


//        String selection = UsersMaster.Users.COLUMN_NAME_ITEM + " LIKE ?";
//        String[] selectionArgs = { item };
//        db.delete(UsersMaster.Cart.CART_TABLE_NAME,selection,selectionArgs);
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

    public Cursor getCartRowData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+UsersMaster.Cart_row.CART_ROW_TABLE_NAME+" where "+UsersMaster.Cart_row.CART_ROW_ID+"="+id+"", null );
        return res;
    }

    public Cursor getCartData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+UsersMaster.Cart.CART_TABLE_NAME+" where "+UsersMaster.Cart.CART_ID+"="+id+"", null );
        return res;
    }

    public Cursor getOrderData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ord =  db.rawQuery( "select * from "+UsersMaster.Order.ORDER_TABLE_NAME+" where "+UsersMaster.Order.ORDER_TABLE_ID+"="+id+"", null );
        return ord;
    }

    public void updateCartInfo(int cartID,String item, String quantity, String size){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersMaster.Cart_row.COLUMN_NAME_ITEM,item);
        contentValues.put(UsersMaster.Cart_row.COLUMN_NAME_QUANTITY,quantity);
        contentValues.put(UsersMaster.Cart_row.COLUMN_NAME_SIZE,size);

        db.update(UsersMaster.Cart_row.CART_ROW_TABLE_NAME,contentValues,UsersMaster.Cart_row.CART_ROW_ID+" = ? ", new String[] { Integer.toString(cartID) });

//        String cartrowid = Integer.toString(cartRowId);

//        db.execSQL("update "+UsersMaster.Cart_row.CART_ROW_TABLE_NAME+" set "+UsersMaster.Cart_row.COLUMN_NAME_ITEM+"="+item+","+UsersMaster.Cart_row.COLUMN_NAME_QUANTITY+"="+quantity+","+UsersMaster.Cart_row.COLUMN_NAME_SIZE+"="+size+" where "+UsersMaster.Cart_row.CART_ROW_ID+"="+cartID);

//        String item1,item2,item3,item4,quantity1,quantity2,quantity3,quantity4,size2,size3,size4,size1;
//        item1 = item2 = item3 = item4 = quantity1 = quantity2 = quantity3 = quantity4 = size1 = size2 = size3 = size4 = null;
//
//        Cursor res =  db.rawQuery( "select * from "+UsersMaster.Cart.CART_TABLE_NAME+" where "+UsersMaster.Cart.CART_ID+"="+cartID+"", null );
//        res.moveToFirst();
//
//        if (cart_size>0){
//            item1 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM1));
//            quantity1 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY1));
//            size1 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE1));
//
//            if (cart_size>1){
//                item2 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM2));
//                quantity2 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY2));
//                size2 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE2));
//
//                if (cart_size>2){
//                    item3 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM3));
//                    quantity3 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY3));
//                    size3 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE3));
//
//                    if (cart_size>3){
//                        item4 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_ITEM4));
//                        quantity4 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_QUANTITY4));
//                        size4 = res.getString(res.getColumnIndex(UsersMaster.Cart.COLUMN_NAME_SIZE4));
//
//                    }
//                }
//            }
//        }
//
//        if (!res.isClosed())  {
//            res.close();
//        }
//
//        ContentValues contentValues = new ContentValues();
//
//        if (item1 == item && quantity1 ==quantity && size1 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM1,item);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY1,quantity);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE1,size);
//
//        }
//
//        else if (item2 == item && quantity2 ==quantity && size2 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM2,item);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY2,quantity);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE2,size);
//        }
//
//        else if (item3 == item && quantity3 ==quantity && size3 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM3,item);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY3,quantity);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE3,size);
//        }
//
//        else if (item4 == item && quantity4 ==quantity && size4 == size){
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_ITEM4,item);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_QUANTITY4,quantity);
//            contentValues.put(UsersMaster.Cart.COLUMN_NAME_SIZE4,size);
//        }
//
//
//
//
//
//        int count = db.update(UsersMaster.Cart.CART_TABLE_NAME, contentValues, UsersMaster.Cart.CART_ID+" = ? ", new String[] { Integer.toString(cartID) } );
//
//
////        SQLiteDatabase db = getReadableDatabase();
////
////        ContentValues values = new ContentValues();
////        values.put(UsersMaster.Users.COLUMN_NAME_QUANTITY,quantity);
////        values.put(UsersMaster.Users.COLUMN_NAME_SIZE,size);
////
////        String selection = UsersMaster.Users.COLUMN_NAME_ITEM + " LIKE ?";
////        String[] selectionArgs = { item };
////
////        int count = db.update(
////                UsersMaster.Cart.CART_TABLE_NAME,
////                values,
////                selection,
////                selectionArgs
////        );
////
//        return count;
    }


}

