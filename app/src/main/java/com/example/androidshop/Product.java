package com.example.androidshop;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
       /* "_id": "1",
            "nom": "lune",
            "Color": "gris,bleu foncé",
            "Taille": 1.31,
            "categorie": "bille",
            "prix": 14.91,
            "picture": "bille1",
            "about": "Consectetur sint labore est Lorem velit aliquip Lorem. Ut aliqua laboris culpa minim reprehenderit non anim occaecat. Consequat aliqua laboris duis nostrud esse amet dolore proident deserunt cupidatat.\r\n"
    */
    private int id;
    private String nom;
    private String color;
    private double taille;
    private String categorie;
    private double prix;
    private String picture;
    private String about;


    public Product(int id, String nom, String color, double taille, String categorie, double prix, String picture, String about) {
        this.id = id;
        this.nom = nom;
        this.color = color;
        this.taille = taille;
        this.categorie = categorie;
        this.prix = prix;
        this.picture = picture;
        this.about = about;
    }
    protected Product(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        color = in.readString();
        taille = in.readDouble();
        categorie = in.readString();
        prix = in.readDouble();
        picture = in.readString();
        about = in.readString();
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
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
        dest.writeString(picture);
        dest.writeString(about);
    }
}
