package com.example.androidshop;





import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductList extends ArrayList<Product> implements Parcelable {

    public ProductList() {
        super();
    }


    //turn a json file into a string
    public static String loadJSONFromAsset(InputStream is) {
        String json = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public ProductList(String json) {
        super();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Product>>(){}.getType();
        List<Product> products = gson.fromJson(json, listType);
        this.addAll(products);
        //show the list of products in the console
        for (Product product : this) {
            System.out.println(product);
        }
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