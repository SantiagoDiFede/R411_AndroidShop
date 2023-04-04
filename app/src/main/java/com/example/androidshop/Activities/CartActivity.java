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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Intent intent = getIntent();
        ArrayList<Integer> products = intent.getIntegerArrayListExtra("products");
        //make a list of products that have been chosen
        ArrayList<Product> products1 = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            products1.add(ProductList.getProduct(products.get(i)));
        }
        ProductList productList = null;
        try {
            productList = new ProductList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productList.clear();
        productList.addAll(products1);
        ProductAdapter adapter = new ProductAdapter(productList, this);
        ListView listView = findViewById(R.id.products_list);
        listView.setAdapter(adapter);
        Button button = findViewById(R.id.buy_button);
        ProductList finalProductList = productList;
        button.setOnClickListener(v -> {
            System.out.println(UserEmail.getInstance().getEmail());
            Intent intent2 = new Intent(this, PopUpActivity.class);
            EmailSender emailSender = new EmailSender();
            try {
                //make a string of the products
                String productsString = "";
                for (int i = 0; i < products1.size()-1; i++) {
                    productsString += products1.get(i).getCategorie() + " " + products1.get(i).getNom() + ", \n";}
                productsString += products1.get(products1.size()-1).getCategorie() +" "+products1.get(products1.size()-1).getNom() + " pour un total de " + finalProductList.getTotalPrice() + "€";
                emailSender.sendEmail(UserEmail.getInstance().getEmail(),"Confirmation de commande","Votre commande des produits suivant : \n" + productsString + " a bien été reçue et est en cours de préparation.");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }


            startActivity(intent2);
        });
        Button button2 = findViewById(R.id.back_button);
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
