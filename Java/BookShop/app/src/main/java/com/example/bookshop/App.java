package com.example.bookshop;

import android.app.Application;

import com.example.bookshop.di.AppModule;
import com.example.bookshop.di.BookComponent;
import com.example.bookshop.di.DaggerBookComponent;

public class App extends Application {
    private static App app;
    private BookComponent bookComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        bookComponent = DaggerBookComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App getApp() {
        return app;
    }

    public BookComponent getBookComponent() {
        return bookComponent;
    }
}
