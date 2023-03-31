package com.example.td5pizza;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaAdapter extends BaseAdapter {

    private ListPizza listPizza;
    private LayoutInflater layoutInflater;
    private ClickableActivity clickableActivity;

    public PizzaAdapter(ListPizza listPizza,ClickableActivity clickableActivity) {
        this.listPizza = listPizza;
        this.clickableActivity = clickableActivity;
        layoutInflater = LayoutInflater.from(clickableActivity.getContext());

    }

    public int getCount() {
        return listPizza.size();
    }

    public Object getItem(int position) {
        return listPizza.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pizza, parent, false);
        }
        Pizza pizza = listPizza.get(position);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(pizza.getImageResourceId());
        imageView.setContentDescription(pizza.getName());
        TextView textView = view.findViewById(R.id.textView1);
        textView.setText(pizza.getName());
        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setText(pizza.getPrix() + " €");
        //if pizza.getPrix is higher than 10, then change the color of the text to red
        if (pizza.getPrix() >= 10) {
            textView2.setTextColor(0xFFFF0000);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickableActivity.onClickPizza(pizza);
            }
        });
        return view;
    }
    //make an alert dialog with the name of the pizza and the price






}
