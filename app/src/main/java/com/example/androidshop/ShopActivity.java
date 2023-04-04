package com.example.androidshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.text.DecimalFormat;
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
        double prixTotal = ProductList.prixTotal(shopCart);
        TextView prixTotalView = findViewById(R.id.price);
        //check that prixTotal does not have more than 2 decimals
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double roundedNumber = Double.parseDouble(decimalFormat.format(prixTotal));
        prixTotalView.setText("Total : " + roundedNumber + "€");

        TextView label = findViewById(R.id.label);
        ProductList productList = null;
        try {
            productList = new ProductList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        label.setText("Bienvenue!");
        ProductAdapter adapter = new ProductAdapter(productList, this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        Button button = findViewById(R.id.button);
        button.setEnabled(true);
        button.setOnClickListener(v -> {
            if (shopCart.isEmpty()){
                Toast.makeText(this, "You have to choose at least one product", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent1 = new Intent(this, CartActivity.class);
            ArrayList<Integer> productsId = ProductList.getProductsId(shopCart);
            intent1.putIntegerArrayListExtra("products", ProductList.getProductsId(shopCart));
            intent1.putExtra("mailUser", mail);
            startActivity(intent1);
        });
        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, ShopActivity.class);
            shopCart.clear();
            intent1.putParcelableArrayListExtra("shopCart", shopCart);
            startActivity(intent1);
        });



    }



    @Override
    public void onClickProduct(Product product) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("productInfo", (Parcelable) product);
        intent.putExtra("shopCart", shopCart);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
