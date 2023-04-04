package com.example.androidshop.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidshop.Product.Product;
import com.example.androidshop.R;

import java.util.ArrayList;


public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        // Récupère l'objet Product sélectionné depuis l'activité précédente
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("productInfo");

        // Récupère la liste des produits présents dans le panier depuis l'activité précédente
        ArrayList<Product> shopCart = (ArrayList<Product>) intent.getSerializableExtra("shopCart");

        // Affiche l'image du produit
        ImageView imageView = findViewById(R.id.image);
        int image = product.getPicture();
        String imageString = "bille" + image;
        int imageId = getResources().getIdentifier(imageString, "drawable", getPackageName());
        imageView.setImageResource(imageId);

        // Affiche le nom, le prix, la description, le stock, la catégorie, la taille et la couleur du produit
        TextView name = findViewById(R.id.textNom);
        name.setText(product.getNom().substring(0, 1).toUpperCase() + product.getNom().substring(1));
        TextView price = findViewById(R.id.textPrix);
        price.setText("Prix: " + product.getPrix() +"€");
        TextView description = findViewById(R.id.textDescription);
        description.setText(product.getAbout());
        TextView stock = findViewById(R.id.textStock);
        stock.setText("Nombre en stock: " + product.getStock());
        TextView category = findViewById(R.id.textCatégorie);
        category.setText(product.getCategorie());
        TextView taille = findViewById(R.id.textTaille);
        taille.setText("taille: " + product.getTaille() +"cm");
        TextView couleur = findViewById(R.id.textCouleur);
        couleur.setText("couleur: " + product.getColor());

        // Ajoute un bouton pour retourner à l'activité précédente (ShopActivity)
        ImageButton buttonBack = findViewById(R.id.imageButton);
        buttonBack.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, ShopActivity.class);
            intent1.putExtra("shopCart", shopCart);
            startActivity(intent1);
        });

        // Ajoute un bouton pour ajouter le produit au panier et retourner à l'activité précédente (ShopActivity)
        Button button = findViewById(R.id.buyButton);
        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, ShopActivity.class);
            intent1.putExtra("productBought", (Parcelable) product);
            shopCart.add(product);
            intent1.putExtra("shopCart", shopCart);
            startActivity(intent1);
        });
    }
}
