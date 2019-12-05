package com.example.pictest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.List;

public class listActivity extends AppCompatActivity {

    GridView listview;
    Intent intent;
    ArrayList<pic> pics = new ArrayList<>();
    picAdapter picAdapter;
    Cursor cursor;
    private dbAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listview = findViewById(R.id.listview);
        dbAdapter = new dbAdapter(this);
        displayList();


    }
    //攔截設定返回鍵 回上一頁
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Intent intent = new Intent(listActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }return true;
    }

    private void displayList() {
        cursor = dbAdapter.setList();
        if(cursor.moveToFirst()){
            do {
                pics.add(new pic(
                       convertStringToIcon(cursor.getString(1))));
            }while (cursor.moveToNext());
        }
        cursor.moveToFirst();
        picAdapter= new picAdapter(this,pics);
        listview.setAdapter(picAdapter);
    }
    public static Bitmap convertStringToIcon(String st)
    {
        // OutputStream out;
        Bitmap bitmap = null;
        try
        {
            // out = new FileOutputStream("/sdcard/aa.jpg");
            byte[] bitmapArray;
            bitmapArray = Base64.decode(st, Base64.DEFAULT);
            bitmap =
                    BitmapFactory.decodeByteArray(bitmapArray, 0,
                            bitmapArray.length);
            // bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            Log.e("bitmap", String.valueOf(bitmap));
            return bitmap;
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
