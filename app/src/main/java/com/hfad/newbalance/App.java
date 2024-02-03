package com.hfad.newbalance;

import android.app.Application;

import com.hfad.newbalance.db.AppDatabase;

public class App extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        AppDatabase appDatabase = AppDatabase.getInstance(this);

    }
}
