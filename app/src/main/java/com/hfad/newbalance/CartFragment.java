package com.hfad.newbalance;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.newbalance.db.AppDatabase;
import com.hfad.newbalance.db.Item;
import com.hfad.newbalance.db.ItemCart;
import com.hfad.newbalance.db.ItemCartDao;
import com.hfad.newbalance.db.ItemDao;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment implements MyAdapterCart.OnItemClickListener {

    private RecyclerView recyclerView;
    private MyAdapterCart adapterCart;
    private List<ItemCart> itemsCart;
    private Button buttonCartBuy;
    TextView totalSum;
    int total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        buttonCartBuy= view.findViewById(R.id.buttonBuyCart);
        totalSum = view.findViewById(R.id.text_total_price);



        buttonCartBuy.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                adapterCart.ClearCart();
                itemsCart.removeAll(itemsCart);
                total=0;

                totalSum.setText(Integer.toString(total));


            }
        });



        return view;

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        // Получаем данные из базы данных
        AppDatabase appDatabase = AppDatabase.getInstance(requireContext());
        ItemCartDao itemCartDao = appDatabase.getItemCartDao();
        itemsCart = itemCartDao.getAll();


        adapterCart = new MyAdapterCart(itemsCart, this, requireActivity().getSupportFragmentManager(),appDatabase);
        recyclerView.setAdapter(adapterCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));



        for (int i = 0; i < itemsCart.size(); i++) {
            total+= Integer.parseInt(itemsCart.get(i).price);
        }

        totalSum.setText(Integer.toString(total));

    }


    @Override
    public void onItemClick(ItemCart item) {


    }


}