package com.example.parkzan.badsore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String name[] = {"นาย  หมู  พาเพลิน","นาย ขวด ปิดสนิท","นางสาว น้ำ ปิดปากขวด"};
    String resId[] ={"0715847955","0714484895","0715479451"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        ListView listView = (ListView)findViewById(R.id.list_device);
//        Customer cus = new Customer(getApplicationContext(),name,resId);
//        listView.setAdapter(cus);


  }


}
