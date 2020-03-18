package com.example.contactmanager.di;

import com.example.contactmanager.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ContactAppComponent {
    void inject(MainActivity mainActivity);
}
