package com.example.androidshop.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidshop.Email.UserEmail;
import com.example.androidshop.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Afficher l'interface utilisateur de l'activité d'accueil
        setContentView(R.layout.activity_main_accueil);

        // Récupérer les vues de l'interface utilisateur
        EditText mailView = findViewById(R.id.mail);
        Button start = findViewById(R.id.start);

        // Définir un écouteur de clic sur le bouton "Se connecter"
        start.setOnClickListener(v -> {
            // Vérifier si l'adresse e-mail est vide
            if (mailView.getText().toString().isEmpty()) {
                mailView.setError("Mail must not be empty");
                return;
            }

            // Vérifier si l'adresse e-mail est valide
            if (!isValidEmail(mailView.getText().toString())) {
                mailView.setError("Mail must be to format : *@*.*");
                return;
            }

            // Enregistrer l'adresse e-mail dans la classe UserEmail
            UserEmail.getInstance().setEmail(mailView.getText().toString());

            // Lancer l'activité de la boutique
            Intent intent = new Intent(this, ShopActivity.class);
            startActivity(intent);
        });
    }

    // Vérifier si une adresse e-mail est valide
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
}
