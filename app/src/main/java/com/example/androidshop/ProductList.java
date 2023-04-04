package com.example.androidshop;


import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductList extends ArrayList<Product> implements Parcelable {





    public ProductList() throws IOException {
        StrictMode.ThreadPolicy gfgPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(gfgPolicy);
        URL url = new URL("https://api.jsonserve.com/ENnysM");
        InputStream input = url.openStream();
        ObjectMapper mapper = new ObjectMapper();
        Product product[] = mapper.readValue(input, Product[].class);
        for (Product p : product) {
            this.add(p);
        }

    }

    public static double prixTotal(ArrayList<Product> shopCart) {
        double prixTotal = 0;
        for (Product product : shopCart) {
            prixTotal += product.getPrix();
        }
        return prixTotal;
    }




    protected ProductList(Parcel in) throws UnsupportedEncodingException, IOException {
        in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<ProductList> CREATOR = new Creator<ProductList>() {
        @Override
        public ProductList createFromParcel(Parcel in) {
            try {
                return new ProductList(in);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public ProductList[] newArray(int size) {
            return new ProductList[size];
        }
    };

    public static ArrayList<Integer> getProductsId(ArrayList<Product> shopCart) {
        ArrayList<Integer> productsId = new ArrayList<>();
        for (Product product : shopCart) {
            productsId.add(product.getId());
        }
        return productsId;
    }

    public static Product getProduct(Integer id) {
        Product product = null;
        try {
            ProductList productList = new ProductList();
            for (Product p : productList) {
                if (p.getId() == id) {
                    product = p;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

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
            totalPrice += product.getPrix();
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