package com.example.androidshop.Product;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Product implements Parcelable, Serializable {

    private int id;
    private String nom;
    private String color;
    private double taille;
    private String categorie;
    private double prix;
    private int picture;
    private String about;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private int stock;



    @JsonCreator
    public Product(@JsonProperty("id") int id,
                   @JsonProperty("nom") String nom,
                   @JsonProperty("color") String color,
                   @JsonProperty("taille") double taille,
                   @JsonProperty("categorie") String categorie,
                   @JsonProperty("prix") double prix,
                   @JsonProperty("picture") int picture,
                   @JsonProperty("about") String about,
                   @JsonProperty("stock") int stock) {
        this.id = id;
        this.nom = nom;
        this.color = color;
        this.taille = taille;
        this.categorie = categorie;
        this.prix = prix;
        this.picture = picture;
        this.about = about;
        this.stock = stock;
    }







    protected Product(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        color = in.readString();
        taille = in.readDouble();
        categorie = in.readString();
        prix = in.readDouble();
        picture = in.readInt();
        about = in.readString();
        stock = in.readInt();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(color);
        dest.writeDouble(taille);
        dest.writeString(categorie);
        dest.writeDouble(prix);
        dest.writeInt(picture);
        dest.writeString(about);
        dest.writeInt(stock);
    }
}
