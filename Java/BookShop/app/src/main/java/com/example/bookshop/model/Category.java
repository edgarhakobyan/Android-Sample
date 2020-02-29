package com.example.bookshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories_table")
public class Category extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String description;

    public Category() {
    }

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Bindable
    public int getId() {
        return id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(com.example.bookshop.BR.id);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.example.bookshop.BR.name);
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(com.example.bookshop.BR.description);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
