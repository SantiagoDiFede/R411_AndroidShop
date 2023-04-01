package com.example.androidshop;





import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends ArrayList<Product> implements Parcelable {


    public ProductList() {
        // Ajoutez ici les produits à la liste
        this.add(new Product("Bille 1", 1.0, R.drawable.logo));
        this.add(new Product("Bille 2", 2.0, R.drawable.logo));
        this.add(new Product("Bille 3", 3.0, R.drawable.logo));
        this.add(new Product("Bille 4", 0.5, R.drawable.logo));
    }

    protected ProductList(Parcel in) {
        in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<ProductList> CREATOR = new Creator<ProductList>() {
        @Override
        public ProductList createFromParcel(Parcel in) {
            return new ProductList(in);
        }

        @Override
        public ProductList[] newArray(int size) {
            return new ProductList[size];
        }
    };

    public List<Product> getProductList() {
        return this;
    }

    public void addProduct(Product product) {
        this.add(product);
    }

    public void removeProduct(Product product) {
        this.remove(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : this) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this);
    }
}