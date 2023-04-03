package com.example.androidshop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("productInfo");
        ArrayList<Product> shopCart = (ArrayList<Product>) intent.getSerializableExtra("shopCart");
        ImageView imageView = findViewById(R.id.image);
        int image = product.getPicture();
        String imageString = "bille" + image;
        int imageId = getResources().getIdentifier(imageString, "drawable", getPackageName());
        imageView.setImageResource(imageId);
        TextView name = findViewById(R.id.textNom);
        name.setText(product.getNom());
        TextView price = findViewById(R.id.textPrix);
        price.setText(String.valueOf(product.getPrix()));
        TextView description = findViewById(R.id.textDescription);
        description.setText(product.getAbout());
        TextView stock = findViewById(R.id.textStock);
        stock.setText(String.valueOf(product.getStock()));
        TextView category = findViewById(R.id.textCatégorie);
        category.setText(product.getCategorie());
        TextView taille = findViewById(R.id.textTaille);
        taille.setText(String.valueOf(product.getTaille()));
        TextView couleur = findViewById(R.id.textCouleur);
        couleur.setText(product.getColor());
        Button button = findViewById(R.id.buyButton);
        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, ShopActivity.class);
            intent1.putExtra("productBought", (Parcelable) product);
            shopCart.add(product);
            intent1.putExtra("shopCart", shopCart);
            startActivity(intent1);
        });




    }
}

