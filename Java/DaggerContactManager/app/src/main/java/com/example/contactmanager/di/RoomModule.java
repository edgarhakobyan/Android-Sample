package com.example.contactmanager.di;

import android.app.Application;

import androidx.room.Room;

import com.example.contactmanager.db.ContactsAppDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    @Provides
    ContactsAppDatabase provideContactsAppDatabase(Application application) {
        return Room.databaseBuilder(application, ContactsAppDatabase.class, "ContactDB").build();
    }
}
