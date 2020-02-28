package com.example.workmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.workmanagerdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String COUNT_LIMIT_KEY = "count_limit_key";
    public static final String STATUS_KEY = "status_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        Constraints constraints = new Constraints.Builder()
//                .setRequiresCharging(true)
//                .build();

        Data data = new Data.Builder()
                .putInt(COUNT_LIMIT_KEY, 100)
                .build();

        final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(DemoWorker.class)
//                .setConstraints(constraints)
                .setInputData(data)
                .build();

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance(getApplicationContext()).enqueue(oneTimeWorkRequest);
            }
        });

        WorkManager.getInstance(getApplicationContext())
                .getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if (workInfo != null) {
                            binding.tvStatus.setText(workInfo.getState().name());

                            if (workInfo.getState().isFinished()) {
                                Data outData = workInfo.getOutputData();
                                String message = outData.getString(STATUS_KEY);
                                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

    }
}
