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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView label = findViewById(R.id.label);
        ProductList productList = new ProductList();
        ArrayList<Product> products;
        label.setText("Bienvenu sur TrouveTaBille " + name + " !");
        ProductAdapter adapter = new ProductAdapter(productList, this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        Button button = findViewById(R.id.button);
        button.setEnabled(false);
        //make an event listener for the elements
        listView.setOnItemClickListener((parent, view, position, id) -> {
            button.setEnabled(true);
            button.setOnClickListener(v -> {
                Intent intent1 = new Intent(this, InfoActivity.class);
                intent1.putExtra("productInfo", productList.get(position));
                startActivity(intent1);
            });
        });



    }



    @Override
    public void onClickProduct(Product product) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("productInfo", product);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
