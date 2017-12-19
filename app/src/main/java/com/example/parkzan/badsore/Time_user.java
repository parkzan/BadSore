package com.example.parkzan.badsore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ParkZan on 12/1/2017.
 */

public class Time_user extends BaseAdapter {
    Context mContext;
    ArrayList<String> time = new ArrayList<>();

    public Time_user(Context context, ArrayList<String> time) {
        this.mContext= context;
        this.time = time;

    }
    public  Time_user(){

    }

   @Override
    public int getCount() {
        return time.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
            view = mInflater.inflate(R.layout.list_time, viewGroup, false);

        TextView tv_time = (TextView)view.findViewById(R.id.text_time);


        tv_time.setText(time.get(i));


        return view;
    }
}
