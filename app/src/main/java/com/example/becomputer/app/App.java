package com.example.becomputer.app;

import android.app.Application;

import com.example.becomputer.database.AppDatabase;
import com.example.becomputer.database.dao.FoodDao;

public class App extends Application {
    public static AppDatabase db;
    public static FoodDao foodDao;

    @Override
    public void onCreate() { //launch huney bela ma chai yo onCreate(); database fire hunxa
        super.onCreate();

       // initPref(); //sharedpref ma save gareko data
        initDb(); //initializing database
    }

    private void initDb() {
        db = AppDatabase.getInstance(getApplicationContext());
        foodDao= db.foodDao();
    }

}
