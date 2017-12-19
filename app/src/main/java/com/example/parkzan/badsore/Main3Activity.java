package com.example.parkzan.badsore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    public ArrayList<String>  name = new ArrayList<>();
    public ArrayList<String> resId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Customer customer = new Customer();
        customer.addUser("นาย ขวด ปิดสนิท","0714484895");
        customer.addUser("นางสาว น้ำ ปิดปากขวด","0715479451");
        name.add("นาย รังิสมันตุ์ ขอนแก่น");
        name.add("นางสาว หญิง ใจดี");
        resId.add("0714484895");
        resId.add("0715479451");
        try {
            Bundle bundle_qr = getIntent().getExtras();
            String name_code_qr = bundle_qr.getString("name_qrcode");
            String resId_code_qr = bundle_qr.getString("resId_qrcode");
           if(!name_code_qr.isEmpty()) {
               name.add(name_code_qr);
               resId.add(resId_code_qr);
           }
//
//            Bundle bundle = getIntent().getExtras();
//            String name_code = bundle.getString("name");
//            String resId_code = bundle.getString("resId");
//            if(!name_code.isEmpty()) {
//                name.add(name_code);
//                resId.add(resId_code);
//            }




        }catch (Exception e){

        }
        try {

            Bundle bundle = getIntent().getExtras();
            String name_code = bundle.getString("name");
            String resId_code = bundle.getString("resId");
            if(!name_code.isEmpty()) {
                name.add(name_code);
                resId.add(resId_code);
            }




        }catch (Exception e){

        }


        ListView listView = (ListView)findViewById(R.id.list_device2);
        Customer cus = new Customer(getApplicationContext(),name,resId);
        listView.setAdapter(cus);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i){
                    case 0:
                        intent = new Intent(getApplicationContext(),Main5Activity_list1.class);
                        intent.putExtra("name",name.get(i));
                        intent.putExtra("ID",resId.get(i));
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(),Main5Activity_list1.class);
                        intent.putExtra("name",name.get(i));
                        intent.putExtra("ID",resId.get(i));
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(),Main5Activity_list1.class);
                        intent.putExtra("name",name.get(i));
                        intent.putExtra("ID",resId.get(i));
                        startActivity(intent);
                        break;
                }
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);

            }
        });

    }

}
