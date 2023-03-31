package com.example.androidshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ProductAdapter extends BaseAdapter {

    private ListProduct listProduct;
    private LayoutInflater layoutInflater;
    private ClickableActivity clickableActivity;

    public ProductAdapter(ListProduct listProduct, ClickableActivity clickableActivity) {
        this.listProduct = listProduct;
        this.clickableActivity = clickableActivity;
        layoutInflater = LayoutInflater.from(clickableActivity.getContext());

    }

    public int getCount() {
        return listProduct.size();
    }

    public Object getItem(int position) {
        return listProduct.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pizza, parent, false);
        }
        Product product = listProduct.get(position);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(product.getImageResourceId());
        imageView.setContentDescription(product.getName());
        TextView textView = view.findViewById(R.id.textView1);
        textView.setText(product.getName());
        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setText(product.getPrix() + " €");
        //if pizza.getPrix is higher than 10, then change the color of the text to red
        if (product.getPrix() >= 10) {
            textView2.setTextColor(0xFFFF0000);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickableActivity.onClickProduct(product);
            }
        });
        return view;
    }
    //make an alert dialog with the name of the pizza and the price






}
