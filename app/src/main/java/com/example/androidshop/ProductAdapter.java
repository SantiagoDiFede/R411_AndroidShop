package com.example.androidshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ProductAdapter extends BaseAdapter {

    private ProductList productList;
    private LayoutInflater layoutInflater;
    private ClickableActivity clickableActivity;

    public ProductAdapter(ProductList productList, ClickableActivity clickableActivity) {
        this.productList = productList;
        this.clickableActivity = clickableActivity;
        layoutInflater = LayoutInflater.from(clickableActivity.getContext());

    }

    public int getCount() {
        return productList.size();
    }

    public Object getItem(int position) {
        return productList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }


}
