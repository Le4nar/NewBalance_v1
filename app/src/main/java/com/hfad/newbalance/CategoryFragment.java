package com.hfad.newbalance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class CategoryFragment extends Fragment {

    private ImageView ImageWomenCategory;
    private ImageView ImageMenCategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        // Найти картинку
        ImageWomenCategory = view.findViewById(R.id.imageWomenCategory);
        ImageMenCategory = view.findViewById(R.id.imageMenCategory);


        // Добавить слушателя события onClick() к картинке
        ImageWomenCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Заменить текущий фрагмент на новый фрагмент
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new WomanCategory());
                fragmentTransaction.commit();
            }
        });

        ImageMenCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Заменить текущий фрагмент на новый фрагмент
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new ManCategory());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
