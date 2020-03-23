package com.example.lifecycleawarecomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "MYTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getLifecycle().addObserver(new DemoAppComponent("SecondActivity"));

        Log.i(TAG,"***************    SecondActivity onCreate() ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"***************    SecondActivity onResume() ");
    }
}
