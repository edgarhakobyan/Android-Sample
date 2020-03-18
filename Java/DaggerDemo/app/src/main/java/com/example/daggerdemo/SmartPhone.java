package com.example.daggerdemo;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class SmartPhone {
    private static final String TAG = "SmartPhone";
    private Battery battery;
    private MemoryCard memoryCard;
    private SIMCard simCard;
    private String time;

    @Inject
    SmartPhone(Battery battery, MemoryCard memoryCard, SIMCard simCard) {
        this.battery = battery;
        this.memoryCard = memoryCard;
        this.simCard = simCard;
        battery.showType();

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        time = dateFormat.format(Calendar.getInstance().getTime());
    }


    void makeACall(){
        Log.d(TAG, " making a call......... ");
        Log.d(TAG, " created time is " + time);
    }
}
