package com.example.contactmanager;

import android.app.Application;

import com.example.contactmanager.di.ApplicationModule;
import com.example.contactmanager.di.ContactAppComponent;
import com.example.contactmanager.di.DaggerContactAppComponent;

public class App extends Application {
    private static App app;
    private ContactAppComponent contactAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        contactAppComponent = DaggerContactAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static App getApp() {
        return app;
    }

    public ContactAppComponent getContactAppComponent() {
        return contactAppComponent;
    }
}
