package com.example.workmanagerdemo;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DemoWorker extends Worker {
    public DemoWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data data = getInputData();
        int count = data.getInt(MainActivity.COUNT_LIMIT_KEY, 0);

        for (int i = 0; i < count; ++i) {
            Log.i("MYTAG", "Count is " + i);
        }

        Data sendData = new Data.Builder()
                .putString(MainActivity.STATUS_KEY, "Task done successfully")
                .build();

        return Result.success(sendData);
    }
}
