package com.example.pictest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelp extends SQLiteOpenHelper {

    public static final String KEY_ID = "_id";
    public static final String KEY_PIC = "pic";

    public static final String DATABASE_NAME = "memos";
    public static final String TABLE_NAME = "memo";
    public static final int DB_VERSION = 1;

    public dbHelp(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String DATABASE_CREAT = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                KEY_ID + " integer PRIMARY KEY autoincrement," +
                KEY_PIC + ")";
        db.execSQL(DATABASE_CREAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
