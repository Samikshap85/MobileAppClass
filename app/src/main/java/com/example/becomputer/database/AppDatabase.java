package com.example.becomputer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.becomputer.database.dao.FoodDao;
import com.example.becomputer.database.model.FoodEntity;


@Database(entities = {FoodEntity.class} , version=1 , exportSchema=false)
public  abstract class AppDatabase extends RoomDatabase {
    private static  final String DB_Name = "becomputer"; //created a new database name becomputer
    private static AppDatabase instance;
    public abstract FoodDao foodDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) ; //creating instance , if already created then return the instance or else create one
        {
            instance= Room
                    .databaseBuilder(context.getApplicationContext() , AppDatabase.class , DB_Name)
                    .allowMainThreadQueries()
                    .build();
        }

            return instance;

        }




}
