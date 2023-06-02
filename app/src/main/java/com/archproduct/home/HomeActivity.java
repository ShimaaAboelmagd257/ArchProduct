package com.archproduct.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.archproduct.getAllProducts.view.AllProductsActivity;
import com.archproduct.getFavourites.view.FavouriteActivity;
import com.example.archproduct.R;

public class HomeActivity extends AppCompatActivity {

    Button getAll;
    Button getFavourite;
    Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getAll = findViewById(R.id.getAllButton);
        getFavourite = findViewById(R.id.getFavouriteButton);
        exit = findViewById(R.id.exitButton);
        getAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this , AllProductsActivity.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this , FavouriteActivity.class);
                startActivity(intent);
            }
        });
    }
}