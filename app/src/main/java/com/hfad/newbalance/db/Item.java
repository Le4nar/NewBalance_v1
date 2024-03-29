package com.hfad.newbalance.db;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Item implements Serializable {
    public Item() {}
    @PrimaryKey(autoGenerate = true)
   public int id;

    public String name;

    public String description;

    public String price;

    public byte[] imageData;
     public boolean gender;
     // true men
    //false female

public Item (String name,String price, String description, byte[] imageDate, boolean gender){
    this.name=name;
    this.description=description;
    this.price=price;
    this.imageData=imageDate;
    this.gender=gender;
}

}
