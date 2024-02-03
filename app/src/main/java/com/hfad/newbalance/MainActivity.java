package com.hfad.newbalance;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.hfad.newbalance.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    CategoryFragment categoryFragment = new CategoryFragment();
    CartFragment cartFragment = new CartFragment();
    AboutFragment aboutFragment = new AboutFragment();
   CreateFragment createFragment=new CreateFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
//        звмена фрагмента мейн на хом чтобы приложение начинало запуск с хом
//        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                } else if (itemId == R.id.category) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, categoryFragment).commit();
                    return true;
                } else if (itemId == R.id.cart) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, cartFragment).commit();
                    return true;
                } else if (itemId == R.id.about) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();
                    return true;
                }else if (itemId == R.id.create) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, createFragment).commit();
                    return true;
                }


                return false;
            }
        });

    }

    ;


}
