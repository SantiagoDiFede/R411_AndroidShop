package com.example.androidshop;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {






    private String name;
    private int prix;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    private int imageResourceId;



    public Product(String name, int prix, int imageResourceId) {
        this.name = name;
        this.prix = prix;
        this.imageResourceId = imageResourceId;

    }

    public String getName() {
        return name;
    }

    protected Product(Parcel in) {
        name = in.readString();
        prix = in.readInt();
        imageResourceId = in.readInt();

    }

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(prix);
        parcel.writeInt(imageResourceId);


    }
}
