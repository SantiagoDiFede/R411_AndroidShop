package com.example.androidshop.Product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidshop.ClickableActivity;
import com.example.androidshop.R;


// Classe qui gère l'adaptation des données de la liste de produits à la vue de la liste de produits.
public class ProductAdapter extends BaseAdapter {

    private ProductList productList; // Liste des produits
    private LayoutInflater layoutInflater; // Permet d'inflater la vue
    private ClickableActivity clickableActivity; // Référence à l'activité ClickableActivity

    public ProductAdapter(ProductList productList, ClickableActivity clickableActivity) {
        this.productList = productList; // initialisation de la liste des produits
        this.clickableActivity = clickableActivity; // initialisation de l'activité ClickableActivity
        layoutInflater = LayoutInflater.from(clickableActivity.getContext()); // initialisation de l'inflater de la vue
    }

    @Override
    public int getCount() {
        return productList.size(); // retourne le nombre d'éléments dans la liste
    }

    public Object getItem(int position) {
        return productList.get(position); // retourne l'élément à la position donnée
    }

    public long getItemId(int position) {
        return position; // retourne l'ID de l'élément à la position donnée
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view; // La vue à renvoyer
        if (v == null) { // si la vue n'existe pas
            v = layoutInflater.inflate(R.layout.bille_layout, null); // on l'inflate à partir de bille_layout
        }
        Product product = productList.get(i); // récupère le produit à la position i
        ImageView imageView = v.findViewById(R.id.image); // référence à l'ImageView pour l'image du produit
        //set image as "bille" + product.getPicture()
        String imageName = "bille" + product.getPicture(); // le nom de l'image du produit
        int resID = v.getResources().getIdentifier(imageName, "drawable", v.getContext().getPackageName()); // ID de l'image à partir de son nom
        imageView.setImageResource(resID); // définit l'image du produit
        TextView textView = v.findViewById(R.id.nom); // référence au TextView pour le nom du produit
        textView.setText(product.getNom().substring(0, 1).toUpperCase() + product.getNom().substring(1)); // définit le nom du produit en majuscule
        TextView textView2 = v.findViewById(R.id.prix); // référence au TextView pour le prix du produit
        textView2.setText(product.getPrix() + "€"); // définit le prix du produit
        v.setOnClickListener(new View.OnClickListener() { // configure le clickListener de la vue
            @Override
            public void onClick(View view) {
                clickableActivity.onClickProduct(product); // lance l'activité ClickableActivity lorsqu'un produit est cliqué
            }
        });
        return v; // renvoie la vue
    }
}
