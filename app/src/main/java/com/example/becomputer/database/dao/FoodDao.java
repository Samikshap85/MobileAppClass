package com.example.becomputer.database.dao;
//dao == data access object
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.becomputer.database.model.FoodEntity;

import java.util.List;

@Dao

public interface FoodDao {
    @Insert
    void insertItem(FoodEntity foodEntity); //inserting into database

    @Delete
    void deleteItem(FoodEntity foodEntity);

    @Update
    void updataItem(FoodEntity foodEntity);

    @Query("SELECT * FROM FoodEntity")
    List<FoodEntity> getAllItems();

    @Query("DELETE FROM FoodEntity")
    void deleteAll();


}
