package com.example.androidshop.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidshop.ClickableActivity;
import com.example.androidshop.Email.EmailSender;
import com.example.androidshop.Email.UserEmail;
import com.example.androidshop.Product.Product;
import com.example.androidshop.Product.ProductAdapter;
import com.example.androidshop.Product.ProductList;
import com.example.androidshop.R;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;

public class CartActivity extends AppCompatActivity implements ClickableActivity {

    // Méthode appelée lors de la création de l'activité
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart); // On définit le layout à utiliser
        Intent intent = getIntent();
        ArrayList<Integer> products = intent.getIntegerArrayListExtra("products"); // On récupère les produits sélectionnés
        ArrayList<Product> products1 = new ArrayList<>(); // On crée une liste pour stocker les produits
        for (int i = 0; i < products.size(); i++) {
            products1.add(ProductList.getProduct(products.get(i))); // On ajoute les produits à la liste
        }
        ProductList productList = null;
        try {
            productList = new ProductList(); // On récupère la liste des produits
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productList.clear(); // On supprime les produits dans la liste
        productList.addAll(products1); // On ajoute les produits sélectionnés
        ProductAdapter adapter = new ProductAdapter(productList, this); // On crée l'adaptateur pour la liste de produits
        ListView listView = findViewById(R.id.products_list); // On récupère la listeView
        listView.setAdapter(adapter); // On définit l'adaptateur pour la listView
        Button button = findViewById(R.id.buy_button); // On récupère le bouton pour acheter
        ProductList finalProductList = productList;
        button.setOnClickListener(v -> {
            System.out.println(UserEmail.getInstance().getEmail());
            Intent intent2 = new Intent(this, PopUpActivity.class); // On crée l'intent pour afficher la popup de confirmation
            EmailSender emailSender = new EmailSender(); // On crée un objet EmailSender pour envoyer le mail
            try {
                // On crée une chaîne de caractères qui contient les produits sélectionnés
                String productsString = "";
                for (int i = 0; i < products1.size()-1; i++) {
                    productsString += products1.get(i).getCategorie() + " " + products1.get(i).getNom() + ", \n";}
                productsString += products1.get(products1.size()-1).getCategorie() +" "+products1.get(products1.size()-1).getNom() + " pour un total de " + finalProductList.getTotalPrice() + "€";
                emailSender.sendEmail(UserEmail.getInstance().getEmail(),"Confirmation de commande","Votre commande des produits suivant : \n" + productsString + " a bien été reçue et est en cours de préparation.");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }


            startActivity(intent2); // On démarre l'activité pour afficher la popup de confirmation
        });
        Button button2 = findViewById(R.id.back_button); // On récupère le bouton pour revenir au magasin
        button2.setOnClickListener(v -> {

            Intent intent1 = new Intent(this, ShopActivity.class);
            startActivity(intent1);
        });



    }

        @Override
        public void onClickProduct(Product product) {

        }

        @Override
        public Context getContext() {return getApplicationContext();}

}
