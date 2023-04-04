package com.example.androidshop;

import android.content.Context;

import com.example.androidshop.Product.Product;

public interface ClickableActivity {
    public void onClickProduct(Product product);
    Context getContext();
}


