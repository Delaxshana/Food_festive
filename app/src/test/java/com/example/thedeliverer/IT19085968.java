package com.example.thedeliverer;

import android.content.Context;
import android.database.Cursor;

import com.example.thedeliverer.Database.DBHelperOrder;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IT19085968 {
    private DBHelperOrder dbHelperOrder;
    private OrderConfirmation orderConfirmation;
    private Context context;

    @Before
    public void setUp(){
        dbHelperOrder = new DBHelperOrder(context);
        orderConfirmation = new OrderConfirmation();
    }

    //Tests whether the getRowCartData method returns null when cartRowId is zero
    @Test
    public void testingGetCartRowData(){
        Cursor result = dbHelperOrder.getCartRowData(0);
        assertEquals(null,result);
    }

    //Tests whether the summation of quantities is correct
    @Test
    public void testAddQuantities(){
        int result = orderConfirmation.addQuantities(4,5,6);
        assertEquals(15,result);
    }



}
