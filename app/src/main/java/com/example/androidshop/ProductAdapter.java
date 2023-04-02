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

    @Override


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
        View v = view;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.activity_shop, null);
        }
        /*Product product = productList.get(i);
        ImageView imageView = v.findViewById(R.id.imageView3);
        imageView.setImageResource(product.getPicture());
        TextView textView = v.findViewById(R.id.textView);
        textView.setText(product.getName());
        TextView textView2 = v.findViewById(R.id.textView2);
        textView2.setText(product.getPrice() + "€");
        v.setOnClickListener(v1 -> clickableActivity.onClickProduct(product));
        return v;*/
        return null;
    }


}
