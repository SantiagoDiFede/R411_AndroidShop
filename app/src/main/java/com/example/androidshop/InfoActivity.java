package com.example.androidshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        Intent intent = getIntent();
        ImageView imageViewProduct = findViewById(R.id.imageView3);
        ListView listView = findViewById(R.id.listView2);
        TextView textView = findViewById(R.id.textView3);
        TextView textView2 = findViewById(R.id.textView4);
        Product product = (Product) intent.getSerializableExtra("productInfo");



    }
}

