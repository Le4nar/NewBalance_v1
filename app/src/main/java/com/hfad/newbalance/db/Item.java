package com.hfad.newbalance.db;

import android.media.Image;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey(autoGenerate = true)
    int id;

    public String name;

    public String description;

    public String price;

public Item (String name,String price, String description){
    this.name=name;
    this.description=description;
    this.price=price;
}

}
