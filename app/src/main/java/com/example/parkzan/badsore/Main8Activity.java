package com.example.parkzan.badsore;

import android.app.Fragment;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Main8Activity extends AppCompatActivity {
        public static String name_in ;
        public static  String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Fragment fragment = new Main8Activity.setting_profile();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new Main8Activity.setting_profile()).commit();
        Intent intent = getIntent();
        name_in = intent.getStringExtra("name");
        ID = intent.getStringExtra("ID");
    }
    public static  class setting_profile extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting_profile);
            Preference connectToNewComputer= findPreference("name");
            connectToNewComputer.setSummary(name_in);
            Preference number= findPreference("number");
            number.setSummary(ID);

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
