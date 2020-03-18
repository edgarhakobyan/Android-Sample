package com.example.daggerdemo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MemoryCardModule.class, AbstractBatteryModule.class})
public interface SmartPhoneComponent {
//    SmartPhone getSmartPhone();
    void inject(MainActivity mainActivity);
}
