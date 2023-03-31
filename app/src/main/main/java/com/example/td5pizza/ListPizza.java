package com.example.td5pizza;

import java.util.ArrayList;

public class ListPizza extends ArrayList<Pizza> {

    public ListPizza(){
        ArrayList<Ingredient> listIngredient1 = new ArrayList<>();
        listIngredient1.add(new Ingredient(Item.TOMATE,20,"dl"));
        listIngredient1.add(new Ingredient(Item.POIVRON,1,""));
        listIngredient1.add(new Ingredient(Item.CHORIZO,50,"g"));
        listIngredient1.add(new Ingredient(Item.MOZARELLA,50,"g"));

        ArrayList<Ingredient> listIngredient2 = new ArrayList<>();
        listIngredient2.add(new Ingredient(Item.TOMATE,20,"dl"));
        listIngredient2.add(new Ingredient(Item.OIGNON,2,""));
        listIngredient2.add(new Ingredient(Item.POULET,200,"g"));
        listIngredient2.add(new Ingredient(Item.EMMENTAL,50,"g"));

        ArrayList<Ingredient> listIngredient3 = new ArrayList<>();
        listIngredient3.add(new Ingredient(Item.TOMATE,25,"dl"));
        listIngredient3.add(new Ingredient(Item.EMMENTAL,50,"g"));

        ArrayList<Ingredient> listIngredient4 = new ArrayList<>();
        listIngredient4.add(new Ingredient(Item.TOMATE,20,"dl"));
        listIngredient4.add(new Ingredient(Item.CHAMPIGNON,80,"g"));
        listIngredient4.add(new Ingredient(Item.JAMBON,150,"g"));
        listIngredient4.add(new Ingredient(Item.EMMENTAL,50,"g"));
        listIngredient4.add(new Ingredient(Item.OLIVE,3,""));

        ArrayList<Ingredient> listIngredient5 = new ArrayList<>();
        listIngredient5.add(new Ingredient(Item.TOMATE,20,"dl"));
        listIngredient5.add(new Ingredient(Item.CHAMPIGNON,80,"g"));
        listIngredient5.add(new Ingredient(Item.JAMBON,150,"g"));
        listIngredient5.add(new Ingredient(Item.EMMENTAL,50,"g"));

        ArrayList<Ingredient> listIngredient6 = new ArrayList<>();
        listIngredient6.add(new Ingredient(Item.TOMATE,20,"dl"));
        listIngredient6.add(new Ingredient(Item.CHAMPIGNON,80,"g"));
        listIngredient6.add(new Ingredient(Item.BLEU,50,"g"));
        listIngredient6.add(new Ingredient(Item.OLIVE,3,""));
        listIngredient6.add(new Ingredient(Item.GOUDA,50,"g"));
        listIngredient6.add(new Ingredient(Item.EMMENTAL,50,"g"));


        add(new Pizza("Fromage", 4, R.drawable.pizza3, listIngredient4));
        add(new Pizza("Chorizo", 9, R.drawable.pizza2, listIngredient1));
        add(new Pizza("Poulet", 5, R.drawable.pizza1, listIngredient2));
        add(new Pizza("Royale", 7, R.drawable.pizza7, listIngredient6));
        add(new Pizza("Calzone", 2, R.drawable.pizza4, listIngredient4));
        add(new Pizza("Regina", 8, R.drawable.pizza5, listIngredient6));
        add(new Pizza("indienne", 2, R.drawable.pizza6, listIngredient5));
        add(new Pizza("Speciale", 2, R.drawable.pizza8, listIngredient3));
        add(new Pizza("Végetarienne",7, R.drawable.pizza9, listIngredient3));


    }
}
