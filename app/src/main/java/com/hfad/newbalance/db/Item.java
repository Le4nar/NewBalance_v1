package com.hfad.newbalance.db;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    public Item() {}
    @PrimaryKey(autoGenerate = true)
    int id;

    public String name;

    public String description;

    public String price;

    public byte[] imageData;

public Item (String name,String price, String description, byte[] imageDate){
    this.name=name;
    this.description=description;
    this.price=price;
    this.imageData=imageDate;
}

}
