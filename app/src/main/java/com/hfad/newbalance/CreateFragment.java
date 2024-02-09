package com.hfad.newbalance;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.hfad.newbalance.db.AppDatabase;
import com.hfad.newbalance.db.Item;
import com.hfad.newbalance.db.ItemDao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CreateFragment extends Fragment {
    private static final int PICK_IMAGE_REQUEST = 1;
    // Другие поля класса

    private ImageView imageView;
    private ImageButton buttonAttachPhoto;
    private Button button;

    private EditText descriptionEt;
    private EditText priceEt;
    private EditText nameEt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);

        // Нахождение ссылок на элементы интерфейса
        imageView = view.findViewById(R.id.imageView);
        buttonAttachPhoto = view.findViewById(R.id.buttonAttachPhoto);
        button = view.findViewById(R.id.buttonAdd);
        descriptionEt = view.findViewById(R.id.editTextDescription);
        priceEt = view.findViewById(R.id.editTextPrice);
        nameEt = view.findViewById(R.id.editTextName);





        // Остальной код фрагмента


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToDb();

            }
        });
        buttonAttachPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        return view;
    }


    private void openGallery() {
        // Открыть галерею для выбора фотографии
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Обработка результатов выбора фотографии из галереи
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }  private void addToDb() {
        String name = nameEt.getText().toString();
        String description = descriptionEt.getText().toString();
        String price = priceEt.getText().toString();



        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        Bitmap bitmap = imageView.getDrawingCache();

        // Преобразование объекта Bitmap в массив байтов
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] imageData = stream.toByteArray();

        AppDatabase appDatabase = AppDatabase.getInstance(requireContext());
        ItemDao itemDao = appDatabase.getItemDao();

        Item item = new Item(name,price,description,imageData);
        itemDao.insert(item);
    }



}