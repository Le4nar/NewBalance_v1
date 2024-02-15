package com.hfad.newbalance;

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

import com.hfad.newbalance.db.Item;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterCategory extends RecyclerView.Adapter<MyAdapterCategory.MyViewHolder> {

    private OnItemClickListener listener; // Объявление интерфейса
    private ArrayList<Item> items;

    private FragmentManager fragmentManager; // Добавьте это поле


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public MyAdapterCategory(ArrayList<Item> items, OnItemClickListener listener) {
        this.items = items;
        this.listener=listener;
    }
    public MyAdapterCategory(ArrayList<Item> items) {
        this.items = items;

    }

    public MyAdapterCategory(ArrayList<Item> items, OnItemClickListener listener, FragmentManager fragmentManager) {
        this.items = items;
        this.listener = listener;
        this.fragmentManager = fragmentManager; // Присвойте переданный FragmentManager
    }
    public interface OnItemClickListener {
         void onItemClick(Item item);
    }

    public void onItemClick(View view, int position) {
        int itemId = items.get(position).id;
        Bundle args = new Bundle();
        args.putInt("itemId", itemId);
        ItemDetailsFragment fragment = ItemDetailsFragment.newInstance(items.get(position));
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }



    // Создаем новые представления (вызывается layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Создаем новый элемент списка путем заполнения макета
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    // Заменяет содержимое представления (вызывается layout manager)

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item currentItem = items.get(position);
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
