package com.hfad.newbalance;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.newbalance.db.AppDatabase;
import com.hfad.newbalance.db.Item;
import com.hfad.newbalance.db.ItemDao;

import java.util.ArrayList;


public class WomenCategory extends Fragment implements MyAdapterCategory.OnItemClickListener{
    private RecyclerView recyclerView;
    private MyAdapterCategory adapterCategory;
    private ArrayList<Item> items;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_women_category, container, false);

        // Инициализируем RecyclerView


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewWomenCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        // Получаем данные из базы данных
        AppDatabase appDatabase = AppDatabase.getInstance(requireContext());
        ItemDao itemDao = appDatabase.getItemDao();
        items = new ArrayList<>(itemDao.getItemsByGender(false));


        adapterCategory = new MyAdapterCategory(items,this, requireActivity().getSupportFragmentManager());
        recyclerView.setAdapter(adapterCategory);

    }



    public void onItemClick(Item item) {
        // Обработка нажатия на элемент списка. Здесь вы можете открыть другой фрагмент и передать данные о выбранном товаре.

        // Создать новый экземпляр ItemDetailsFragment
        ItemDetailsFragment fragment = ItemDetailsFragment.newInstance(item);

        // Получить FragmentManager из активити
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

        // Начать транзакцию фрагмента
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Заменить текущий фрагмент на ItemDetailsFragment
        fragmentTransaction.replace(R.id.container, fragment);

        // Добавить транзакцию в бэкстек
        fragmentTransaction.addToBackStack(null);

        // Зафиксировать транзакцию
        fragmentTransaction.commit();
    }

}