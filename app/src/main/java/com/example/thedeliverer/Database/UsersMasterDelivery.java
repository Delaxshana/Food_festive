package com.example.thedeliverer.Database;

import android.provider.BaseColumns;

public class UsersMasterDelivery {

    public UsersMasterDelivery(){}

    public static class delivery implements BaseColumns{
       public static final String TABLE_NAME1="rider";
       public static final String COLUMN_NAME_RIDERID="riderID";
       public static final String COLUMN_NAME_RIDERNAME="riderName";
       //public static final String COlUMN_NAME_PHONE="phone";
       public static final String COLUMN_NAME_VEHICLENUM="vehicleNo";
    }
}
