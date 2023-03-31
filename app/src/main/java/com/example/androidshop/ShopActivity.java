package com.example.androidshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements ClickableActivity{

    int Pvsum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView label = findViewById(R.id.label);
        ProductList productList = new ProductList();
        label.setText("Faites votre choix "+name+" !");
        ProductAdapter adapter = new ProductAdapter(productList, this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        Button button = findViewById(R.id.button);
        button.setEnabled(false);



    }



    @Override
    public void onClickProduct(Product product) {

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
