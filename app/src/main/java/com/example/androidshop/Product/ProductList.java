package com.example.androidshop.Product;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductList extends ArrayList<Product> implements Parcelable {

    // Constructeur qui lit les données JSON à partir de l'API, les convertit en objets Product et les ajoute à la liste de produits
    public ProductList() throws IOException {
        // Autoriser l'accès au réseau sur le thread principal (ce n'est pas recommandé pour les applications de production)
        StrictMode.ThreadPolicy gfgPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(gfgPolicy);
        // Récupérer les données JSON de l'API
        URL url = new URL("https://api.jsonserve.com/ENnysM");
        InputStream input = url.openStream();
        // Convertir les données JSON en objets Product à l'aide de la bibliothèque Jackson
        ObjectMapper mapper = new ObjectMapper();
        Product product[] = mapper.readValue(input, Product[].class);
        // Ajouter les produits à la liste de produits
        for (Product p : product) {
            this.add(p);
        }
    }

    // Méthode qui calcule le prix total des produits dans le panier d'achat
    public static double prixTotal(ArrayList<Product> shopCart) {
        double prixTotal = 0;
        for (Product product : shopCart) {
            prixTotal += product.getPrix();
        }
        return prixTotal;
    }

    // Constructeur de Parcelable qui permet de passer la liste de produits entre les activités
    protected ProductList(Parcel in) throws UnsupportedEncodingException, IOException {
        in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<ProductList> CREATOR = new Creator<ProductList>() {
        // Créer une nouvelle instance de ProductList à partir de la parcelle
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

    // Méthode qui retourne une liste d'identifiants de produits pour les produits dans le panier d'achat
    public static ArrayList<Integer> getProductsId(ArrayList<Product> shopCart) {
        ArrayList<Integer> productsId = new ArrayList<>();
        for (Product product : shopCart) {
            productsId.add(product.getId());
        }
        return productsId;
    }

    // Méthode qui retourne un objet Product à partir d'un identifiant de produit donné
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

    // Méthode qui retourne une liste de produits
    public List<Product> getProductList() {
        return this;
    }

    // Méthode qui ajoute un produit à la liste de produits
    public void addProduct(Product product) {
        this.add(product);
    }

    // Supprimer un produit de la liste
    public void removeProduct(Product product) {
        this.remove(product);
    }

    // Renvoie le prix total des produits dans la liste
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : this) {
            totalPrice += product.getPrix();
        }
        return totalPrice;
    }

    // Interface Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    // Interface Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this);
    }
}