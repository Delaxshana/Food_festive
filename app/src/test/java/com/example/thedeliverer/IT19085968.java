package com.example.thedeliverer;

import android.content.Context;

import com.example.thedeliverer.Database.DBHelperOrder;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IT19085968 {
    private DBHelperOrder dbHelperOrder;
    private Context context;

    @Before
    public void setUp(){
        dbHelperOrder = new DBHelperOrder(context);
    }

    @Test
    public void testinsertingOrdertable(){
        String result = dbHelperOrder.addOrderTableInfo(null,null,null,null);
        assertEquals(null,result);
    }

}
