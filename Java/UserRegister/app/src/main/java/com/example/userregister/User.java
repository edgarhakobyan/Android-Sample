package com.example.userregister;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    private int userId;

    private String name;
    private String email;
    private String country;
    private String registeredTime;

    @Ignore
    public User() {}

    public User(int userId, String name, String email, String country, String registeredTime) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.country = country;
        this.registeredTime = registeredTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
        notifyPropertyChanged(BR.registeredTime);
    }

    public int getUserId() {
        return userId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getCountry() {
        return country;
    }

    @Bindable
    public String getRegisteredTime() {
        return registeredTime;
    }
}
