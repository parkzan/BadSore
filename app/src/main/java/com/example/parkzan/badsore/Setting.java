package com.example.parkzan.badsore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by ParkZan on 12/1/2017.
 */

public class Setting extends PreferenceFragment {
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_screen);
//             Preference reset = (Preference) findPreference("profile");
//        reset.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            @Override
//            public boolean onPreferenceClick(Preference preference) {
//                Main7Activity_setting main7Activity_setting = new Main7Activity_setting();
//                Intent intent = new Intent(main7Activity_setting.Intentpage(),MainActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        });

    }
}
