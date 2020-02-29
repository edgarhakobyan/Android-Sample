package com.example.bookshop;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.bookshop.model.Book;

import java.util.ArrayList;

public class BooksDiffCallback extends DiffUtil.Callback {
    private ArrayList<Book> oldBooks;
    private ArrayList<Book> newBooks;

    public BooksDiffCallback(ArrayList<Book> oldBooks, ArrayList<Book> newBooks) {
        this.oldBooks = oldBooks;
        this.newBooks = newBooks;
    }

    @Override
    public int getOldListSize() {
        return oldBooks == null ? 0 : oldBooks.size();
    }

    @Override
    public int getNewListSize() {
        return newBooks == null ? 0 : newBooks.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldBooks.get(oldItemPosition).getBookId() == newBooks.get(newItemPosition).getBookId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldBooks.get(oldItemPosition).equals(newBooks.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
