package com.example.parkzan.badsore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ParkZan on 10/31/2017.
 */
public class Customer extends BaseAdapter {
        Context mContext;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> resId = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();

        public Customer(Context context,  ArrayList<String> strName,  ArrayList<String> resId) {
            this.mContext= context;
            this.name = strName;
            this.resId = resId;

        }
        public  Customer(){

        }
        public void addUser(String strName,  String resId){
            name.add(strName);
            name.add(resId);

        }
        public ArrayList<String> getUser(){
            return name;
        }
    public ArrayList<String> getUserid(){
        return resId;
    }
        @Override
        public int getCount() {
            return name.size();
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
                view = mInflater.inflate(R.layout.list_ex, viewGroup, false);

            TextView tv_name = (TextView)view.findViewById(R.id.text_user);
            TextView tv_id = (TextView)view.findViewById(R.id.textview_id);
            ImageView image_user = (ImageView) view.findViewById(R.id.imageView3);
            image_user.setImageResource(R.mipmap.ic_launcher);

                tv_name.setText(name.get(i));
                tv_id.setText(resId.get(i));

            return view;
        }
    }

