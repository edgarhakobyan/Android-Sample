package com.example.bookshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookShopRepository;
import com.example.bookshop.model.Category;

import java.util.List;

// Removed AndroidViewModel as we use Dagger injection
public class MainActivityViewModel extends ViewModel {
    private BookShopRepository bookShopRepository;

    MainActivityViewModel(BookShopRepository bookShopRepository) {
        this.bookShopRepository = bookShopRepository;
    }

    public LiveData<List<Category>> getAllCategories() {
        return bookShopRepository.getCategories();
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId) {
        return bookShopRepository.getBooks(categoryId);
    }

    public void addNewBook(Book book) {
        bookShopRepository.insertBook(book);
    }

    public void updateBook(Book book) {
        bookShopRepository.updateBook(book);
    }

    public void deleteBook(Book book) {
        bookShopRepository.deleteBook(book);
    }
}
