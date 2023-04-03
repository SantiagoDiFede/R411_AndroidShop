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

            EditText mailView = findViewById(R.id.mail);
            Button start = findViewById(R.id.start);
            start.setOnClickListener(v -> {
                if (mailView.getText().toString().isEmpty()) {
                    mailView.setError("Mail must not be empty");
                    return;
                    }
                String mail = mailView.getText().toString();
                Intent intent = new Intent(this, ShopActivity.class);
                intent.putExtra("mail", mail);
                startActivity(intent);
            });


        }
}