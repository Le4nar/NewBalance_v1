package com.hfad.newbalance;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class CategoryFragment extends Fragment {
//    MenCategoryFragment menCategoryFragment=new MenCategoryFragment();
//    WomenCategoryFragment womenCategoryFragment= new WomenCategoryFragment();
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_category, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        ImageView imageViewWomenCategory = view.findViewById(R.id.imageWomenCategory);
//        ImageView imageViewMenCategory = view.findViewById(R.id.imageMenCategory);
//        imageViewWomenCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Код для перехода на другой фрагмент
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.bottom_navigation, womenCategoryFragment);
//                fragmentTransaction.addToBackStack(null); // Если нужно добавить транзакцию в стек возврата
//                fragmentTransaction.commit();
//
//            }
//        });
//        imageViewMenCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Код для перехода на другой фрагмент
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.bottom_navigation, menCategoryFragment);
//                fragmentTransaction.addToBackStack(null); // Если нужно добавить транзакцию в стек возврата
//                fragmentTransaction.commit();
//            }
//        });
//    }
}
