package com.example.parkzan.badsore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by ParkZan on 12/4/2017.
 */

public class alarm extends BroadcastReceiver {
    Ringtone ringtone;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm Warning !!!",Toast.LENGTH_LONG).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alarmUri == null){
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
         ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

    }
    public void onDestroy()
    {
        ringtone.stop();
    }
}
