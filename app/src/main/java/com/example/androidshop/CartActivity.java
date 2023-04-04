package com.example.androidshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;

public class CartActivity extends AppCompatActivity implements ClickableActivity{

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
        button.setOnClickListener(v -> {
            System.out.println(UserEmail.getInstance().getEmail());
            Intent intent2 = new Intent(this, PopUpActivity.class);
            EmailSender emailSender = new EmailSender();
            try {
                emailSender.sendEmail(UserEmail.getInstance().getEmail(),"Your order has been received","Your order has been received");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }


            startActivity(intent2);
        });



    }

        @Override
        public void onClickProduct(Product product) {

        }

        @Override
        public Context getContext() {return getApplicationContext();}

}
