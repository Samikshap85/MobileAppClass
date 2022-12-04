package com.example.becomputer.app;

import android.app.Application;

import com.example.becomputer.database.AppDatabase;

public class App extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() { //launch huney bela ma chai yo onCreate(); database fire hunxa
        super.onCreate();

       // initPref(); //sharedpref ma save gareko data
        initDb(); //initializing database
    }

    private void initDb() {
        db = AppDatabase.getInstance(getApplicationContext());
    }

}
