package com.hfad.newbalance.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemCartDao {
    @Query("SELECT * FROM itemCart")
    List<ItemCart> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ItemCart itemCart);

    @Query("SELECT id FROM itemCart WHERE id = :itemCartId")
    int getId(int itemCartId);

    @Delete
    void delete(ItemCart itemCart);

    @Query("SELECT * FROM itemCart WHERE name = :name")
    List<ItemCart> getItemByName(String name);

    @Query("SELECT * FROM itemCart WHERE gender = :gender")
    List<ItemCart> getItemsByGender(Boolean gender);
}
