package com.example.thedeliverer;

import android.content.Context;

import com.example.thedeliverer.Database.TableControllerDelivery;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IT19085104 {
    private TableControllerDelivery tableControllerDelivery;
    private Context context;


    @Before
    public void setUp(){
        tableControllerDelivery = new TableControllerDelivery(context);
    }

    //Tests whether the number of records in the delivery table initially are zero
    @Test
    public void testcountRecordsInitial(){
        int result = tableControllerDelivery.count();

        assertEquals(0,result);

    }

}
