package com.example.daggerdemo;

import android.util.Log;

import javax.inject.Inject;

public class ImplementBattery implements Battery {
    private static final String TAG = "SmartPhone";

    @Inject
    ImplementBattery() {
    }

    @Override
    public void showType() {
        Log.d(TAG, " this is a implementation of battery ... ");
    }
}
