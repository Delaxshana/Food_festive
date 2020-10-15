package com.example.thedeliverer;

import android.content.Context;

import com.example.thedeliverer.Database.DBHelper;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IT19085968 {
    private DBHelper dbHelper;
    private Context context;

    @Before
    public void setUp(){
        dbHelper = new DBHelper(context);
    }

    @Test
    public void testinsertingOrdertable(){
        String result = dbHelper.addOrderTableInfo(null,null,null,null);
        assertEquals(null,result);
    }

}
