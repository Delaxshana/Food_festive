package com.example.thedeliverer.Database;

import android.provider.BaseColumns;

public class OrderCommonVariables {
    public OrderCommonVariables() {
    }

    //Cart row table columns
    public static class Cart_row implements BaseColumns{
        public static final String CART_ROW_TABLE_NAME = "cartrow";
        public static final String CART_ROW_ID = "cartrowID";
        public static final String COLUMN_NAME_ITEM = "item";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
        public static final String COLUMN_NAME_SIZE = "size";
    }

    //Cart table columns
    public static  class Cart implements BaseColumns{
        public static final String CART_TABLE_NAME = "foodcart";
        public static final String CART_ID = "carts_id";
        public static final String COLUMN_NAME_ITEM1 = "item1";
        public static final String COLUMN_NAME_ITEM2 = "item2";
        public static final String COLUMN_NAME_ITEM3 = "item3";
        public static final String COLUMN_NAME_ITEM4 = "item4";
        public static final String COLUMN_NAME_QUANTITY1 = "quantity1";
        public static final String COLUMN_NAME_QUANTITY2 = "quantity2";
        public static final String COLUMN_NAME_QUANTITY3 = "quantity3";
        public static final String COLUMN_NAME_QUANTITY4 = "quantity4";
        public static final String COLUMN_NAME_SIZE1 = "size1";
        public static final String COLUMN_NAME_SIZE2 = "size2";
        public static final String COLUMN_NAME_SIZE3 = "size3";
        public static final String COLUMN_NAME_SIZE4 = "size4";

    }

    //Order table columns
    public static class Order implements BaseColumns{
        public static final String ORDER_TABLE_NAME = "orders";
        public static final String ORDER_TABLE_ID = "orderID";
        public static final String CART_TABLE_ID = "cartID";
        public static final String COLUMN_NAME_EXTRA = "extra_material";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_TIME = "time";

    }



}
