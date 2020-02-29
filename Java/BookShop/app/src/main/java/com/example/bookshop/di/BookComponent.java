package com.example.bookshop.di;

import com.example.bookshop.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface BookComponent {
    void inject(MainActivity mainActivity);
}
