package com.example.daggerdemo;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
class MemoryCardModule {
    private static final String TAG = "SmartPhone";
    private int memorySize;

    public MemoryCardModule(int memorySize) {
        this.memorySize = memorySize;
    }

    @Provides
    MemoryCard provideMemoryCard() {
        Log.d(TAG, "Memory size is " + memorySize);
        return new MemoryCard();
    }
}
