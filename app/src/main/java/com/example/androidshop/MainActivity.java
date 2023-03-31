package com.example.androidshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity implements ClickableActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListProduct listProduct = new ListProduct();
        ProductAdapter productAdapter = new ProductAdapter(listProduct, this);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(productAdapter);


    }



    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    public void onClickProduct(Product product) {
        //make an alert dialog with the name of the product and the price
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Confirmation");
        builder.setMessage("Voulez-vous commander une product " + product.getName() + " pour " + product.getPrix() + " € ?");
        builder.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(com.example.androidshop.MainActivity.this, InfoActivity.class);
                intent.putExtra("productInfo", product);
                startActivity(intent);
            }
        });
        builder.setNeutralButton("Annuler",null);
        AlertDialog dialog = builder.create();

        dialog.show();
    }


}