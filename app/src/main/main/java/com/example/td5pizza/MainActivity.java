package com.example.td5pizza;

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
        ListPizza listPizza = new ListPizza();
        PizzaAdapter pizzaAdapter = new PizzaAdapter(listPizza, this);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(pizzaAdapter);


    }



    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    public void onClickPizza(Pizza pizza) {
        //make an alert dialog with the name of the pizza and the price
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Confirmation");
        builder.setMessage("Voulez-vous commander une pizza " + pizza.getName() + " pour " + pizza.getPrix() + " € ?");
        builder.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("pizzaInfo",pizza);
                startActivity(intent);
            }
        });
        builder.setNeutralButton("Annuler",null);
        AlertDialog dialog = builder.create();

        dialog.show();
    }


}