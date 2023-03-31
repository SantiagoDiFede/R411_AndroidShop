package com.example.td5pizza;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Ingredient implements Parcelable {
    private Item name;
    private int prix;

    private String mesure;


    public Ingredient(Item nom, int prix, String mesure) {
        this.name = nom;
        this.prix = prix;
        this.mesure = mesure;
    }

    protected Ingredient(Parcel in) {
        name = in.readParcelable(Item.class.getClassLoader());
        prix = in.readInt();
        mesure = in.readString();
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public Item getName() {
        return name;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name.toString());
        parcel.writeInt(prix);
        parcel.writeString(mesure);
    }
}
