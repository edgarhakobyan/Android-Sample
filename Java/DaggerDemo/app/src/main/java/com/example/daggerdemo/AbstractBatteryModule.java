package com.example.daggerdemo;

import dagger.Binds;
import dagger.Module;

@Module
abstract class AbstractBatteryModule {
    @Binds
    abstract Battery bindNCBattery(ImplementBattery battery);
}
