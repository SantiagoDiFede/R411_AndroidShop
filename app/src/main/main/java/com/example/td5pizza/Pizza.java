package com.example.td5pizza;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Pizza  implements Parcelable {




    private Object[] listIngredient;

    private float extraFromage;
    private float extraOlive;
    private float extraChampignon;

    private String name;
    private int prix;

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
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



    public Pizza(String name, int prix, int imageResourceId, ArrayList<Ingredient> listIngredient) {
        this.name = name;
        this.prix = prix;
        this.imageResourceId = imageResourceId;
        this.listIngredient = listIngredient.toArray();

    }

    public String getName() {
        return name;
    }

    protected Pizza(Parcel in) {
        name = in.readString();
        prix = in.readInt();
        imageResourceId = in.readInt();
        extraFromage = in.readFloat();
        extraChampignon = in.readFloat();
        extraOlive = in.readFloat();
        listIngredient = in.readArray(Ingredient.class.getClassLoader());
    }

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(prix);
        parcel.writeInt(imageResourceId);
        parcel.writeFloat(extraFromage);
        parcel.writeFloat(extraChampignon);
        parcel.writeFloat(extraOlive);
        parcel.writeArray(listIngredient);

    }
}
