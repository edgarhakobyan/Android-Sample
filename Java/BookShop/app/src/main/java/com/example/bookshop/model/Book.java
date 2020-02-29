package com.example.bookshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Objects;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "books_table", foreignKeys = @ForeignKey(entity = Category.class,
        parentColumns = "id", childColumns = "category_id", onDelete = CASCADE))
public class Book extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int bookId;

    @ColumnInfo(name = "book_name")
    private String bookName;

    @ColumnInfo(name = "book_price")
    private String bookPrice;

    @ColumnInfo(name = "category_id")
    private int categoryId;

    public Book() {
    }

    public Book(int bookId, String bookName, String bookPrice, int categoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.categoryId = categoryId;
    }

    @Bindable
    public int getBookId() {
        return bookId;
    }

    @Bindable
    public String getBookName() {
        return bookName;
    }

    @Bindable
    public String getBookPrice() {
        return bookPrice;
    }

    @Bindable
    public int getCategoryId() {
        return categoryId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
        notifyPropertyChanged(com.example.bookshop.BR.bookId);
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(com.example.bookshop.BR.bookName);
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
        notifyPropertyChanged(com.example.bookshop.BR.bookPrice);
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(com.example.bookshop.BR.categoryId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() &&
                getCategoryId() == book.getCategoryId() &&
                getBookName().equals(book.getBookName()) &&
                getBookPrice().equals(book.getBookPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBookName(), getBookPrice(), getCategoryId());
    }
}
