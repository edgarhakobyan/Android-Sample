package com.example.edgar.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.edgar.todolist.database.AppDatabase;
import com.example.edgar.todolist.database.TaskEntry;

public class AddTaskViewModel extends ViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();
    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        Log.d(TAG, "Receive specific task from the DataBase");
        task = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
