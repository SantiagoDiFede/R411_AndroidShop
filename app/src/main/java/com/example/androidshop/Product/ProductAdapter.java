package com.example.androidshop.Product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidshop.ClickableActivity;
import com.example.androidshop.R;


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
            v = layoutInflater.inflate(R.layout.bille_layout, null);
        }
        Product product = productList.get(i);
        ImageView imageView = v.findViewById(R.id.image);
        //set image as "bille" + product.getPicture()
        String imageName = "bille" + product.getPicture();
        int resID = v.getResources().getIdentifier(imageName, "drawable", v.getContext().getPackageName());
        imageView.setImageResource(resID);
        TextView textView = v.findViewById(R.id.nom);
        //first letter in uppercase
        textView.setText(product.getNom().substring(0, 1).toUpperCase() + product.getNom().substring(1));
        TextView textView2 = v.findViewById(R.id.prix);
        textView2.setText(product.getPrix() + "€");
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickableActivity.onClickProduct(product);
            }
        });
        return v;
    }


}
