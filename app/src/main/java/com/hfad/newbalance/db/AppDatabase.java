package com.hfad.newbalance.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.hfad.newbalance.db.ItemDao;

@Database(version = 1, entities = {Item.class, ItemCart.class})

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract ItemDao getItemDao();
    public abstract ItemCartDao getItemCartDao();


    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context,
                            AppDatabase.class,
                            "app_database"
                    ).allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
