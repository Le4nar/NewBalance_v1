package com.hfad.newbalance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.hfad.newbalance.db.Item;

import java.io.Serializable;


public class ItemDetailsFragment extends Fragment {

    private Item item; // Объект товара, для которого отображаются детали
    public static ItemDetailsFragment newInstance(Bundle args) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }



    // Метод для создания нового экземпляра фрагмента с передачей товара в качестве аргумента
    public static ItemDetailsFragment newInstance(Item item) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", (Serializable) item); // передача объекта Item в качестве Serializable в Bundle
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable("item"); // Получаем товар из аргументов
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

            // Добавьте код для настройки изображения товара и обработки нажатия на кнопку "Купить", если это необходимо
        }

        return view;
    }

}
