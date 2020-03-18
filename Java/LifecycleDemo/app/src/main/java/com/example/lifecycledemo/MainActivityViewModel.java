package com.example.lifecycledemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int clickCount = 0;
    private MutableLiveData<Integer> countLiveData = new MutableLiveData<>();

    MutableLiveData<Integer> getInitialCount() {
        countLiveData.setValue(clickCount);
        return countLiveData;
    }

    void updateCurrentCount() {
        ++clickCount;
        countLiveData.setValue(clickCount);
    }
}
