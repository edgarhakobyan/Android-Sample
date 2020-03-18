package com.example.lifecycledemo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView countText;

    MainActivityViewModel mainActivityViewModel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        countText = findViewById(R.id.count_text);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        LiveData<Integer> count = mainActivityViewModel.getInitialCount();

        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                countText.setText("Count is: "+ integer);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.updateCurrentCount();
            }
        });
    }
}
