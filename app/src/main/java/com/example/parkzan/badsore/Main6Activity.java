package com.example.parkzan.badsore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {
       public ArrayList<String> timer = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main6);
//        timer.add("07:15:55น.");
//        timer.add("08:00:17น.");
//        timer.add("09:32:49น.");
//        timer.add("10:00:24น.");
//        timer.add("10:35:15น.");
        ListView list_time = (ListView)findViewById(R.id.list_time);
        Intent intent = getIntent();
        timer = intent.getStringArrayListExtra("his_array");
        Time_user time  = new Time_user(getApplicationContext(),timer);
        list_time.setAdapter(time);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==  android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
