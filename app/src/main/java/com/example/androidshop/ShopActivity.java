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

    ArrayList<Product> shopCart = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        System.out.println("ShopActivity");

        Intent intent = getIntent();
        String mail = intent.getStringExtra("mail");
        if (intent.hasExtra("shopCart")){
            shopCart = intent.getParcelableArrayListExtra("shopCart");
        }

        TextView label = findViewById(R.id.label);
        ProductList productList = new ProductList();
        label.setText("Bienvenue!");
        ProductAdapter adapter = new ProductAdapter(productList, this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        Button button = findViewById(R.id.button);
        button.setEnabled(false);
        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, CartActivity.class);
            ArrayList<Integer> productsId = ProductList.getProductsId(shopCart);
            intent1.putIntegerArrayListExtra("products", ProductList.getProductsId(shopCart));
            startActivity(intent1);
        });



    }



    @Override
    public void onClickProduct(Product product) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("productInfo", product);
        intent.putExtra("shopCart", shopCart);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
