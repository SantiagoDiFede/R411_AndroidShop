package com.example.androidshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_accueil);

            EditText nameView = findViewById(R.id.name);
            Button start = findViewById(R.id.start);
            start.setOnClickListener(v -> {
                if (nameView.getText().toString().isEmpty()) {
                    nameView.setError("Name must not be empty");
                    return;
                    }
                String name = nameView.getText().toString();
                Intent intent = new Intent(this, ShopActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            });


        }
}