package com.example.bookshop.di;

import android.app.Application;

import com.example.bookshop.model.BookShopRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    BookShopRepository provideRepository(Application application) {
        return new BookShopRepository(application);
    }
}
