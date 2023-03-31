package com.example.td5pizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        Intent intent = getIntent();
        ImageView imageViewPizza = findViewById(R.id.imageView3);
        ListView listView = findViewById(R.id.listView2);
        TextView textView = findViewById(R.id.textView3);
        TextView textView2 = findViewById(R.id.textView4);
        Pizza pizza = (Pizza) intent.getSerializableExtra("pizzaInfo");
        textView2.setText(pizza.getName());
        textView.setText(pizza.getPrix());
        imageViewPizza.setImageResource(pizza.getImageResourceId());





    }
}

