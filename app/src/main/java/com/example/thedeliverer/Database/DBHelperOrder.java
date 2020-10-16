package com.example.thedeliverer.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelperOrder extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "UserInfo.db";
    private static final String TAG = "DBHelper" ;

    //Constructor for helper class
    public DBHelperOrder(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    //Creating the tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_FOOD_CART_ENTRIES =
                "CREATE TABLE " + OrderCommonVariables.Cart.CART_TABLE_NAME + " ("+
                        OrderCommonVariables.Cart.CART_ID + " INTEGER PRIMARY KEY," +
                        OrderCommonVariables.Cart.COLUMN_NAME_ITEM1 + " TEXT," +
                        OrderCommonVariables.Cart.COLUMN_NAME_ITEM2 + " TEXT," +
                        OrderCommonVariables.Cart.COLUMN_NAME_ITEM3 + " TEXT," +
                        OrderCommonVariables.Cart.COLUMN_NAME_ITEM4 + " TEXT," +
                        OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY1 + " TEXT,"+
                        OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY2 + " TEXT,"+
                        OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY3 + " TEXT,"+
                        OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY4 + " TEXT,"+
                        OrderCommonVariables.Cart.COLUMN_NAME_SIZE1 + " TEXT,"+
                        OrderCommonVariables.Cart.COLUMN_NAME_SIZE2 + " TEXT,"+
                        OrderCommonVariables.Cart.COLUMN_NAME_SIZE3 + " TEXT,"+
                        OrderCommonVariables.Cart.COLUMN_NAME_SIZE4 + " TEXT)";

        db.execSQL(SQL_CREATE_FOOD_CART_ENTRIES);

        String SQL_CREATE_ORDER_ENTRIES =
                "CREATE TABLE " + OrderCommonVariables.Order.ORDER_TABLE_NAME + " ("+
                        OrderCommonVariables.Order.ORDER_TABLE_ID + " INTEGER PRIMARY KEY," +
                        OrderCommonVariables.Order.CART_TABLE_ID + " TEXT,"+
                        OrderCommonVariables.Order.COLUMN_NAME_EXTRA + " TEXT,"+
                        OrderCommonVariables.Order.COLUMN_NAME_DATE + " TEXT,"+
                        OrderCommonVariables.Order.COLUMN_NAME_TIME + " TEXT)";

        db.execSQL(SQL_CREATE_ORDER_ENTRIES);

        String SQL_CREATE_CART_ROW_ENTRIES =
                "CREATE TABLE " + OrderCommonVariables.Cart_row.CART_ROW_TABLE_NAME + " ("+
                        OrderCommonVariables.Cart_row.CART_ROW_ID + " INTEGER PRIMARY KEY," +
                        OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM + " TEXT,"+
                        OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY + " TEXT,"+
                        OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE + " TEXT)";

        db.execSQL(SQL_CREATE_CART_ROW_ENTRIES);
    }

    //Drop tables
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + OrderCommonVariables.Cart.CART_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + OrderCommonVariables.Order.ORDER_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + OrderCommonVariables.Cart_row.CART_ROW_TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    //Insert data into Cart Table
    public String addCartTableInfo(String item1,String item2,String item3,String item4, String quantity1, String quantity2, String quantity3,String quantity4, String size1,String size2,String size3,String size4){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(OrderCommonVariables.Cart.COLUMN_NAME_ITEM1,item1);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_ITEM2,item2);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_ITEM3,item3);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_ITEM4,item4);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY1,quantity1);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY2,quantity2);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY3,quantity3);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY4,quantity4);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_SIZE1,size1);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_SIZE2,size2);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_SIZE3,size3);
        values.put(OrderCommonVariables.Cart.COLUMN_NAME_SIZE4,size4);

        long newRowId = db.insert(OrderCommonVariables.Cart.CART_TABLE_NAME,null,values);

        //Retrieve the ID of the newly inserted cart table
        String cartID = readAllcartsInfo("cart_ID");
        if (newRowId>0){
            return cartID;
        }
        else{
            return null;
        }
    }

    //Insert data into the Order table
    public String addOrderTableInfo(String cart_id,String extra,String date, String time){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(OrderCommonVariables.Order.CART_TABLE_ID,cart_id);
        values.put(OrderCommonVariables.Order.COLUMN_NAME_EXTRA,extra);
        values.put(OrderCommonVariables.Order.COLUMN_NAME_DATE,date);
        values.put(OrderCommonVariables.Order.COLUMN_NAME_TIME,time);

        long newRowId = db.insert(OrderCommonVariables.Order.ORDER_TABLE_NAME,null,values);
        String orderID = null;
        if (newRowId>0){
            //Retrieve the ID of the newly inserted order table
            orderID = readAllOrderInfo("order_ID");
            return orderID;
        }
        else{
            return null;
        }
    }

    //Insert data into the Cart Row Table
    public String addCartRowTableInfo(String item,String quantity,String size){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM,item);
        values.put(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY,quantity);
        values.put(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE,size);

        long newRowId = db.insert(OrderCommonVariables.Cart_row.CART_ROW_TABLE_NAME,null,values);
        String cartRowID = null;
        if (newRowId>0){
            //Retrieve the ID of the newly inserted cart row table
            cartRowID = readAllCartRowInfo("spc_carts_ID");
            return cartRowID;
        }
        else{
            return null;
        }
    }


    //Retrieve data from cart table
    public String readAllcartsInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                OrderCommonVariables.Cart.CART_ID,
                OrderCommonVariables.Cart.COLUMN_NAME_ITEM1,
                OrderCommonVariables.Cart.COLUMN_NAME_ITEM2,
                OrderCommonVariables.Cart.COLUMN_NAME_ITEM3,
                OrderCommonVariables.Cart.COLUMN_NAME_ITEM4,
                OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY1,
                OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY2,
                OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY3,
                OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY4,
                OrderCommonVariables.Cart.COLUMN_NAME_SIZE1,
                OrderCommonVariables.Cart.COLUMN_NAME_SIZE2,
                OrderCommonVariables.Cart.COLUMN_NAME_SIZE3,
                OrderCommonVariables.Cart.COLUMN_NAME_SIZE4
        };

        String sortOrder = OrderCommonVariables.Cart.COLUMN_NAME_ITEM1 + " DESC";

        Cursor cursor = db.query(
                OrderCommonVariables.Cart.CART_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        String cart_id = null;
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


        while (cursor.moveToNext()){
            cart_id = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.CART_ID));
            item1 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_ITEM1));
            item2 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_ITEM2));
            item3 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_ITEM3));
            item4 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_ITEM4));
            quantity1 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY1));
            quantity2 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY2));
            quantity3 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY3));
            quantity4 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_QUANTITY4));
            size1 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_SIZE1));
            size2 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_SIZE2));
            size3 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_SIZE3));
            size4 = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart.COLUMN_NAME_SIZE4));

        }
        cursor.close();

        if (req=="cart_ID") {
            return cart_id;
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

    //Retrieving data from the Order table
    public String readAllOrderInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                OrderCommonVariables.Order.ORDER_TABLE_ID,
                OrderCommonVariables.Order.CART_TABLE_ID,
                OrderCommonVariables.Order.COLUMN_NAME_EXTRA,
                OrderCommonVariables.Order.COLUMN_NAME_DATE,
                OrderCommonVariables.Order.COLUMN_NAME_TIME
        };

        String sortOrder = OrderCommonVariables.Order.ORDER_TABLE_ID + " DESC";

        Cursor cursor = db.query(
                OrderCommonVariables.Order.ORDER_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        String cartid = null;
        String order_id = null;
        String extra = null;
        String date = null;
        String time = null;


        if(cursor != null)
        {
            if (cursor.moveToFirst()) {
                order_id = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Order.ORDER_TABLE_ID));
            }
            cursor.close();
        }

        db.close();

        if (req=="order_ID") {
            return order_id;
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

    //Retrieving data from the cart row table
    public String readAllCartRowInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                OrderCommonVariables.Cart_row.CART_ROW_ID,
                OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM,
                OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY,
                OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE
        };

        String sortOrder = OrderCommonVariables.Cart_row.CART_ROW_ID + " DESC";

        Cursor cursor = db.query(
                OrderCommonVariables.Cart_row.CART_ROW_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        String spcCartRow = null;
        String cartrowid = null;
        String item = null;
        String quantity = null;
        String size = null;

        if(cursor != null)
        {
            if (cursor.moveToFirst()) {
                spcCartRow = cursor.getString(cursor.getColumnIndexOrThrow(OrderCommonVariables.Cart_row.CART_ROW_ID));
            }
            cursor.close();
        }

        db.close();


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


    //Delete order table when the orderID is given
    public void deleteOrder(int order_ID){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from "+ OrderCommonVariables.Order.ORDER_TABLE_NAME+" where "+ OrderCommonVariables.Order.ORDER_TABLE_ID+"="+order_ID);
    }

    //Delete cart row table when the cart row ID is given
    public void deleteCartRowInfo(int cartRowId){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from "+ OrderCommonVariables.Cart_row.CART_ROW_TABLE_NAME+" where "+ OrderCommonVariables.Cart_row.CART_ROW_ID+"="+cartRowId);

    }

    //Retrieve data from cart row table when cart row ID is given
    public Cursor getCartRowData(int id) {
        Cursor res = null;
        if (id == 0){
            return res;
        }
        else {
            SQLiteDatabase db = this.getReadableDatabase();
            res =  db.rawQuery( "select * from "+ OrderCommonVariables.Cart_row.CART_ROW_TABLE_NAME+" where "+ OrderCommonVariables.Cart_row.CART_ROW_ID+"="+id+"", null );
            return res;
        }
    }

    //Retreive data from cart table when cart ID is given
    public Cursor getCartData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+ OrderCommonVariables.Cart.CART_TABLE_NAME+" where "+ OrderCommonVariables.Cart.CART_ID+"="+id+"", null );
        return res;
    }

    //Retrieve data from order table when order ID is given
    public Cursor getOrderData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ord =  db.rawQuery( "select * from "+ OrderCommonVariables.Order.ORDER_TABLE_NAME+" where "+ OrderCommonVariables.Order.ORDER_TABLE_ID+"="+id+"", null );
        return ord;
    }

    //Update data in cart row table
    public int updateCartRowInfo(int cartID,String item, String quantity, String size){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(OrderCommonVariables.Cart_row.COLUMN_NAME_ITEM,item);
        contentValues.put(OrderCommonVariables.Cart_row.COLUMN_NAME_QUANTITY,quantity);
        contentValues.put(OrderCommonVariables.Cart_row.COLUMN_NAME_SIZE,size);

        int count  = db.update(OrderCommonVariables.Cart_row.CART_ROW_TABLE_NAME,contentValues, OrderCommonVariables.Cart_row.CART_ROW_ID+" = ? ", new String[] { Integer.toString(cartID) });
        return count;

    }


}

