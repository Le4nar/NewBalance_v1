package com.hfad.newbalance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hfad.newbalance.db.AppDatabase;
import com.hfad.newbalance.db.Item;
import com.hfad.newbalance.db.ItemCart;
import com.hfad.newbalance.db.ItemCartDao;


import java.io.Serializable;

public class ItemDetailsFragment extends Fragment {

    private Item item; // Объект товара, для которого отображаются детали

    public static ItemDetailsFragment newInstance(Item item) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item); // передача объекта Item в качестве Serializable в Bundle
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = (Item) getArguments().getSerializable("item"); // Получаем товар из аргументов
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);

        if (item != null) {
            // Найти и настроить текстовое представление для названия товара
            TextView nameTextView = view.findViewById(R.id.product_name);
            nameTextView.setText(item.name);

            // Найти и настроить другие элементы интерфейса, такие как описание, цена, изображение и кнопка "Купить"
            // Пример:
            TextView descriptionTextView = view.findViewById(R.id.product_description);
            descriptionTextView.setText(item.description);

            TextView priceTextView = view.findViewById(R.id.product_price);
            priceTextView.setText(item.price);
            Bitmap bitmap = BitmapFactory.decodeByteArray(item.imageData, 0, item.imageData.length);
            ImageView imageView = view.findViewById(R.id.product_image);
            imageView.setImageBitmap(bitmap);

            // Добавьте код для настройки изображения товара и обработки нажатия на кнопку "Купить", если это необходимо
        } else {
            // Отобразить сообщение об ошибке или заглушку
        }

        Button buyButton = view.findViewById(R.id.btnBuy);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Добавить код для добавления товара в ItemCart
                AppDatabase appDatabase = AppDatabase.getInstance(requireContext());
                ItemCartDao itemCartDao = appDatabase.getItemCartDao();
                ItemCart itemCart= new ItemCart(item.name,item.price,item.description,item.imageData,item.gender);
                itemCartDao.insert(itemCart);

                // Отобразить сообщение об успешном добавлении
                Toast.makeText(getContext(), "Товар добавлен в корзину!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
