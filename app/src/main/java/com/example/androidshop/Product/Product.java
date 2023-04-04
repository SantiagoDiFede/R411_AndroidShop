package com.example.androidshop.Product;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Product implements Parcelable, Serializable {

    private int id; // identifiant unique du produit
    private String nom; // nom du produit
    private String color; // couleur du produit
    private double taille; // taille du produit
    private String categorie; // catégorie du produit
    private double prix; // prix du produit
    private int picture; // ressource de l'image du produit
    private String about; // description du produit

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private int stock; // stock disponible du produit

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

    // Constructeur vide
    public Product() {}

    // Getters et setters pour les attributs de la classe

    // Méthodes nécessaires pour l'interface Parcelable
    // Elles permettent de passer un objet de type Product entre différentes activités de l'application

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

    // Getters et setters pour les attributs de la classe

    // Méthodes nécessaires pour l'interface Parcelable
    // Elles permettent de passer un objet de type Product entre différentes activités de l'application

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
