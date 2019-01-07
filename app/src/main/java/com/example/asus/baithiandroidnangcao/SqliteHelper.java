package com.example.asus.baithiandroidnangcao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.asus.baithiandroidnangcao.Contants.CREATE_MAP_TABLE;
import static com.example.asus.baithiandroidnangcao.Contants.MAP_TABLE;
import static com.example.asus.baithiandroidnangcao.Contants.isDEBUG;


public class SqliteHelper extends SQLiteOpenHelper {
    public SqliteHelper(Context context) {
        super(context, "DB.MAP", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MAP_TABLE);
        if (isDEBUG) Log.e(MAP_TABLE, CREATE_MAP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MAP_TABLE);
    }
}
