package com.hfad.newbalance;

import androidx.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {

    public abstract ItemDao itemDao();
}
