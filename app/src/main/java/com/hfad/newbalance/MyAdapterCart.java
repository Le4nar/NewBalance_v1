package com.hfad.newbalance;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.newbalance.db.AppDatabase;
import com.hfad.newbalance.db.Item;
import com.hfad.newbalance.db.ItemCart;
import com.hfad.newbalance.db.ItemCartDao;

import java.util.ArrayList;
import java.util.List;


public class MyAdapterCart extends RecyclerView.Adapter<MyAdapterCategory.MyViewHolder> {

private OnItemClickListener listener; // Объявление интерфейса
private List<ItemCart> items;

private FragmentManager fragmentManager;

    AppDatabase appDatabase;

public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
        }


public MyAdapterCart(List<ItemCart> items, OnItemClickListener listener) {
        this.items = items;
        this.listener=listener;
        }
public MyAdapterCart(List<ItemCart> items) {
        this.items = items;

        }

public MyAdapterCart(List<ItemCart> items, OnItemClickListener listener, FragmentManager fragmentManager,  AppDatabase appDatabase) {
        this.items = items;
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    this.appDatabase= appDatabase;
        }


public interface OnItemClickListener {
    void onItemClick(ItemCart item);
}

    public void onItemClick(View view, int position) {

    }



    // Создаем новые представления (вызывается layout manager)
    @NonNull
    @Override
    public MyAdapterCategory.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Создаем новый элемент списка путем заполнения макета
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyAdapterCategory.MyViewHolder(view);
    }

    // Заменяет содержимое представления (вызывается layout manager)


    @Override
    public void onBindViewHolder(@NonNull MyAdapterCategory.MyViewHolder holder, int position) {
        ItemCart currentItem = items.get(position);
        // Устанавливаем данные в представления
        holder.nameTextView.setText(currentItem.name);
        holder.descriptionTextView.setText(currentItem.description);
        holder.priceTextView.setText(currentItem.price+" grn");
        Bitmap bitmap = BitmapFactory.decodeByteArray(currentItem.imageData, 0, currentItem.imageData.length);
        // Преобразование массива байтов в изображение
        if (currentItem.imageData != null && bitmap != null) {
            holder.imageView.setImageBitmap(bitmap);
        } else {
            holder.imageView.setImageResource(R.drawable.placeholder_image);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(currentItem);
                }
            }
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    public void ClearCart(){



        ItemCartDao itemCartDao = appDatabase.getItemCartDao();

        itemCartDao.deleteAll();

    }




    // Возвращает размер данных (вызывается layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

// ViewHolder хранит представления элемента списка
public static class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView;
    public TextView descriptionTextView;
    public TextView priceTextView;
    public ImageView imageView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        priceTextView = itemView.findViewById(R.id.priceTextView);
        imageView = itemView.findViewById(R.id.product_image);

    }
}

}
