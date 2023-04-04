package com.example.androidshop.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidshop.ClickableActivity;
import com.example.androidshop.Product.Product;
import com.example.androidshop.Product.ProductAdapter;
import com.example.androidshop.Product.ProductList;
import com.example.androidshop.R;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements ClickableActivity {

    // ArrayList pour stocker les produits ajoutés au panier
    ArrayList<Product> shopCart = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        System.out.println("ShopActivity");

        // Récupération des produits ajoutés au panier depuis l'activité précédente
        Intent intent = getIntent();
        if (intent.hasExtra("shopCart")){
            shopCart = intent.getParcelableArrayListExtra("shopCart");
        }

        // Calcul du prix total des produits dans le panier
        double prixTotal = ProductList.prixTotal(shopCart);
        TextView prixTotalView = findViewById(R.id.price);
        // Vérification que le prix total a moins de 2 décimales
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double roundedNumber = Double.parseDouble(decimalFormat.format(prixTotal));
        prixTotalView.setText("Total : " + roundedNumber + "€");

        // Affichage de la liste des produits disponibles
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

        // Configuration des boutons "Acheter" et "Revenir au magasin"
        Button button = findViewById(R.id.button);
        button.setEnabled(true);
        button.setOnClickListener(v -> {
            if (shopCart.isEmpty()){
                // Affichage d'un message d'erreur si aucun produit n'a été ajouté au panier
                Toast.makeText(this, "You have to choose at least one product", Toast.LENGTH_SHORT).show();
                return;
            }
            // Passage à l'activité du panier en envoyant les IDs des produits ajoutés
            Intent intent1 = new Intent(this, CartActivity.class);
            ArrayList<Integer> productsId = ProductList.getProductsId(shopCart);
            intent1.putIntegerArrayListExtra("products", ProductList.getProductsId(shopCart));
            startActivity(intent1);
        });
        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(v -> {
            // Retour à l'activité principale en supprimant tous les produits ajoutés au panier
            Intent intent1 = new Intent(this, ShopActivity.class);
            shopCart.clear();
            intent1.putParcelableArrayListExtra("shopCart", shopCart);
            startActivity(intent1);
        });

    }

    // Méthode appelée lorsqu'un produit est cliqué dans la liste des produits disponibles
    @Override
    public void onClickProduct(Product product) {
        // Passage à l'activité d'information sur le produit cliqué en envoyant les produits déjà ajoutés au panier
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
