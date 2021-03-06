package com.unique.overhust.Record;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fhw on 2/18/14.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "overhust.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS NavigationRecord" + "(id INTEGER PRIMARY KEY AUTOINCREMENT,fromPlace VARCHAR,toPlace VARCHAR,date TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS SearchRecord" + "(id INTEGER PRIMARY KEY AUTOINCREMENT,place VARCHAR,date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
