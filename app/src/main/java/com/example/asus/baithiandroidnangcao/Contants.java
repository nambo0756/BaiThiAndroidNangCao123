package com.example.asus.baithiandroidnangcao;

public class Contants {

    public final static boolean isDEBUG = true;

    public final static String MAP_TABLE = "tablemap";
    public final static String MAP_LATITUDE = "latitude";
    public final static String MAP_LONGTITUDE = "longtitude";
    public final static String MAP_TIEUDE= "tieuDe";
    public final static String MAP_ID = "id";

    public final static String CREATE_MAP_TABLE = " CREATE TABLE " + MAP_TABLE + " (" +
            "" + MAP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "" + MAP_LATITUDE + " DOUBLE ," +
            "" + MAP_LONGTITUDE + " DOUBLE " +
            "" + MAP_TIEUDE + "TEXT" +
            ")";
}
