package com.example.bookshop.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.bookshop.model.BookShopRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    private BookShopRepository bookShopRepository;

    @Inject
    MainActivityViewModelFactory(BookShopRepository bookShopRepository) {
        this.bookShopRepository = bookShopRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(bookShopRepository);
    }
}
