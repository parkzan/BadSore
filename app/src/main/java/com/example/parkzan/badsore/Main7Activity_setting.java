package com.example.parkzan.badsore;

import android.app.Application;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Main7Activity_setting extends AppCompatActivity {
   public static Context mContext ;
    public static String name_in ;
    public static String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7_setting);
        mContext = Main7Activity_setting.this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Fragment fragment = new settingScreen();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new settingScreen()).commit();
        Intent intent = getIntent();
        name_in = intent.getStringExtra("name");
        ID = intent.getStringExtra("ID");

    }


    public static class settingScreen extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting_screen);
            Preference connectToNewComputer= findPreference("profile");
            connectToNewComputer.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(mContext,Main8Activity.class);
                    intent.putExtra("name",name_in);
                    intent.putExtra("ID",ID);

                startActivity(intent);
                 return  true;
                }
            });

        }

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
