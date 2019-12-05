package com.example.pictest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class dbAdapter {

    public static final String KEY_ID = "_id";
    public static final String KEY_PIC = "pic";

    public static final String DATABASE_NAME = "memos";
    public static final String TABLE_NAME = "memo";
    private dbHelp dbHelp;
    private SQLiteDatabase sqLiteDatabase;
    private  Context context;
    private ContentValues contentValues;

    public dbAdapter(Context context) {
        this.context = context;

        dbHelp = new dbHelp(context);
        sqLiteDatabase = dbHelp.getWritableDatabase();
    }
    public long creat(String pic){
        long id = 0;
        try{
            contentValues = new ContentValues();
            contentValues.put(KEY_PIC,pic);
            id = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.close();
            Toast.makeText(context,"加入成功",Toast.LENGTH_SHORT).show();
        }return id;
    }
    public Cursor setList(){
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{KEY_ID,KEY_PIC},
                null,null,null,null,null,null);

        if (cursor !=null){
            cursor.moveToFirst();
        }return cursor;
    }
}
