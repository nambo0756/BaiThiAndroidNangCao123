package com.example.asus.baithiandroidnangcao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;
import java.util.List;

import static com.example.asus.baithiandroidnangcao.Contants.MAP_ID;
import static com.example.asus.baithiandroidnangcao.Contants.MAP_LATITUDE;
import static com.example.asus.baithiandroidnangcao.Contants.MAP_LONGTITUDE;
import static com.example.asus.baithiandroidnangcao.Contants.MAP_TABLE;
import static com.example.asus.baithiandroidnangcao.Contants.MAP_TIEUDE;


public class Map_DAO {
    private SQLiteDatabase sqLiteDatabase;
    private SqliteHelper sqliteHelper;

    public Map_DAO(SqliteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public long insertMap(Map map) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MAP_LATITUDE, map.getLatitude());
        values.put(MAP_LONGTITUDE, map.getLongtitude());
        values.put(MAP_TIEUDE,map.getTieuDe());
        long result = sqLiteDatabase.insert(MAP_TABLE, null, values);
        return result;
    }

    public List<Map> getAllMap() {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        List<Map> mapList = new ArrayList<>();
        String GET_ALL_MAP = "SELECT * FROM " + MAP_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery(GET_ALL_MAP, null);
        if (cursor != null & cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Map map = new Map();
                map.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(MAP_ID))));
                map.setLatitude(Double.parseDouble(cursor.getString(cursor.getColumnIndex(MAP_LATITUDE))));
                map.setLongtitude(Double.parseDouble(cursor.getString(cursor.getColumnIndex(MAP_LONGTITUDE))));
                map.setTieuDe(cursor.getString(cursor.getColumnIndex(MAP_TIEUDE)));
                mapList.add(map);
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();
        }
        return mapList;
    }

    public Map getMapbyID(int id) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        Map map = null;
        Cursor cursor = sqLiteDatabase.query(MAP_TABLE, null, MAP_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null & cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                map = new Map();
                map.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(MAP_ID))));
                map.setLatitude(Double.parseDouble(cursor.getString(cursor.getColumnIndex(MAP_LATITUDE))));
                map.setLongtitude(Double.parseDouble(cursor.getString(cursor.getColumnIndex(MAP_LONGTITUDE))));
                map.setTieuDe(cursor.getString(cursor.getColumnIndex(MAP_TIEUDE)));
                break;
            }
            cursor.close();
        }
        return map;
    }

    public long updateMap(Map map) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MAP_LATITUDE, map.getLatitude());
        values.put(MAP_LONGTITUDE, map.getLongtitude());
        values.put(MAP_TIEUDE,map.getTieuDe());
        long result = sqLiteDatabase.update(MAP_TABLE, values, MAP_ID + "=?", new String[]{String.valueOf(map.getId())});
        return result;
    }

    public long deleteMap(int id) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        long result = sqLiteDatabase.delete(MAP_TABLE, MAP_ID + "=?", new String[]{String.valueOf(id)});
        return result;
    }

}
