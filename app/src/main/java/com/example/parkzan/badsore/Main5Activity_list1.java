package com.example.parkzan.badsore;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main5Activity_list1 extends AppCompatActivity {
    public ArrayList<String> name = new ArrayList<>();
    public ArrayList<String> resId = new ArrayList<>();
    public ArrayList<String> history = new ArrayList<>();
    String name_in ;
    String ID ;
    alarm k = new alarm();
    CountDownTimer cdt;
    TextView tv;
    String time_histoty ;
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_list1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final TextView tv_his = (TextView)findViewById(R.id.textView8);
//        name.add("นาย ขวด ปิดสนิท");
//        name.add("นางสาว น้ำ ปิดปากขวด");
//        resId.add("0714484895");
//        resId.add("0715479451");

        String fontPath = "font/digital7.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        Bundle bundle = getIntent().getExtras();
        String name_check = bundle.getString("name");
        String resId_check = bundle.getString("ID");
        int resID_check = Integer.parseInt(resId_check);
        tv = (TextView) findViewById(R.id.textView_sh);
        tv.setTypeface(tf);
        tv.setText("02:00:00");
        //7200000
          final CounterClass timer = new CounterClass(7200000,1000);
        timer.start();

        Intent intent = getIntent();
         name_in = intent.getStringExtra("name");
         ID = intent.getStringExtra("ID");
        final TextView tv_history = (TextView)findViewById(R.id.textView_history);
        tv_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                final String formattedDate = df.format(c.getTime());
                tv_history.setText(formattedDate);
                history.add(formattedDate+" น.");
                timer.start();


            }
        });
        tv_his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity_list1.this,Main6Activity.class);
                intent.putStringArrayListExtra("his_array",history);
                startActivity(intent);
            }
        });


            TextView tv_sr = (TextView)findViewById(R.id.textView_sr);
            tv_sr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        k.onDestroy();
                        timer.start();
                    }catch (Exception e){

                    }
                }
            });

        }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer{

        public CounterClass(long millis,long countDown){
            super(millis,countDown);
        }
        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long l) {
            long mills = l;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(mills),
                    TimeUnit.MILLISECONDS.toMinutes(mills) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(mills)),
                    TimeUnit.MILLISECONDS.toSeconds(mills) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mills)));



            tv.setText(hms);

        }

        @Override
        public void onFinish() {
            tv.setText("Warning !!!");
            k.onReceive(Main5Activity_list1.this,null);

        }
    }



   // @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==  android.R.id.home){
            this.finish();
            return  true;
        }
        if(id ==  R.id.id_set){
            Intent intent = new Intent(Main5Activity_list1.this,Main7Activity_setting.class);
            intent.putExtra("name",name_in);
            intent.putExtra("ID",ID);
            startActivity(intent);
            return  true;
        }

        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }





}
