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
import java.util.List;


public class CartFragment extends Fragment implements MyAdapterCategory.OnItemClickListener {

    private RecyclerView recyclerView;
    private MyAdapterCategory adapterCategory;
    private List<ItemCart> itemsCart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cart, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        setupRecycler();



        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        // Получаем данные из базы данных
        AppDatabase appDatabase = AppDatabase.getInstance(requireContext());
        ItemCartDao itemCartDao = appDatabase.getItemCartDao();
        itemsCart = itemCartDao.getAll();
        ArrayList<Item> items = null;
        for (int i = 0; i < itemsCart.size(); i++) {
            String name = itemsCart.get(i).name;
            String price = itemsCart.get(i).price;
            String description = itemsCart.get(i).description;
            byte[] imageData = itemsCart.get(i).imageData;
            boolean gender = itemsCart.get(i).gender;
            Item item = new Item(name, price, description, imageData, gender);

            items.add(item);
        }

        adapterCategory = new MyAdapterCategory(items, this, requireActivity().getSupportFragmentManager());
        recyclerView.setAdapter(adapterCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));


    }

    private void setupRecycler() {
        recyclerView = requireView().findViewById(R.id.recyclerViewCart);
    }

    @Override
    public void onItemClick(Item item) {

    }
}