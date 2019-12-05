package com.example.pictest;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;


import java.util.ArrayList;

public class picAdapter extends BaseAdapter {

    private Context context;
    LayoutInflater inflater;
    private ArrayList<pic> pics;

    public picAdapter(Context context, ArrayList<pic> pics) {
        inflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return pics.size();
    }

    @Override
    public Object getItem(int position) {
        return pics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pics.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        pic pic = (pic)getItem(position);
        convertView = inflater.inflate(R.layout.card,null);

        ImageView imageView = convertView.findViewById(R.id.imageView2);

        imageView.setImageBitmap(pic.getPic());

        return convertView;
    }
}

