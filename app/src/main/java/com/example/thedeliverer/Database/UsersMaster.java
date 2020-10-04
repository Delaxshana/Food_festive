package com.example.thedeliverer.Database;

import android.provider.BaseColumns;

public class UsersMaster {
    public UsersMaster() {
    }

    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
//        public static final String CART_ID = "Cart_ID";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String CART_TABLE_NAME = "foodcart";
        public static final String COLUMN_NAME_ITEM = "item";
//        public static final String COLUMN_NAME_ITEM2 = "item2";
//        public static final String COLUMN_NAME_ITEM3 = "item3";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
//        public static final String COLUMN_NAME_QUANTITY2 = "quantity2";
//        public static final String COLUMN_NAME_QUANTITY3 = "quantity3";
        public static final String COLUMN_NAME_SIZE = "size";
//        public static final String COLUMN_NAME_SIZE2 = "size2";
//        public static final String COLUMN_NAME_SIZE3 = "size3";
    }

}