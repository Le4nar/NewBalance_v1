package com.hfad.newbalance.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM item")
    List<Item> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Item item);



    @Delete
    void delete(Item item);

    @Query("SELECT * FROM item WHERE name = :name")
    List<Item> getItemByName(String name);
}
