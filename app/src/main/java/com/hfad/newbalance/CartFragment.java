package com.hfad.newbalance;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.newbalance.db.AppDatabase;
import com.hfad.newbalance.db.Item;
import com.hfad.newbalance.db.ItemCart;
import com.hfad.newbalance.db.ItemCartDao;
import com.hfad.newbalance.db.ItemDao;

import java.util.ArrayList;


public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapterCategory adapterCategory;
    private ArrayList<ItemCart> itemsCart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cart, container, false);



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewManCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


//        // Получаем данные из базы данных
//        AppDatabase appDatabase = AppDatabase.getInstance(requireContext());
//        ItemCartDao itemCartDao = appDatabase.getItemCartDao();
//        itemsCart = new ArrayList<>(itemCartDao.getItemsByGender(true));
//
//
//        adapterCategory = new MyAdapterCategory(itemsCart,this, requireActivity().getSupportFragmentManager());
//        recyclerView.setAdapter(adapterCategory);

    }

}