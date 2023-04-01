package com.example.androidshop;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {
    private String name;
    private double pu;
    private int image;

    public Product(String name, double price, int image) {
        this.name = name;
        this.pu = price;
        this.image = image;
    }

    protected Product(Parcel in) {
        name = in.readString();
        pu = in.readDouble();
        image = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return pu;
    }

    public void setPrice(double price) {
        this.pu = price;
    }

    public int getImageResource() {
        return image;
    }

    public void setImageResource(int imageResource) {
        this.image = imageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(pu);
        dest.writeInt(image);
    }
}
