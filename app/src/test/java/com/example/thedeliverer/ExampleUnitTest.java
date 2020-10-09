package com.example.thedeliverer;

import android.content.Context;

import com.example.thedeliverer.Database.TableControllerDelivery;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

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