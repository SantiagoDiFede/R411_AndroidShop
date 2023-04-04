package com.example.androidshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_accueil);

            EditText mailView = findViewById(R.id.mail);
            Button start = findViewById(R.id.start);
            start.setOnClickListener(v -> {
               /* if (mailView.getText().toString().isEmpty()) {
                    mailView.setError("Mail must not be empty");
                    return;
                }

                if (!isValidEmail(mailView.getText().toString())) {
                    mailView.setError("Mail must be to format : *@*.*");
                    return;
                }*/
                String mail = mailView.getText().toString();
                Intent intent = new Intent(this, ShopActivity.class);
                intent.putExtra("mail", mail);

                // Créez une instance de la classe Intent avec l'action ACTION_SEND
                Intent intentmail = new Intent(Intent.ACTION_SEND);

                // Ajoutez l'adresse e-mail de destination
                intentmail.putExtra(Intent.EXTRA_EMAIL, new String[] {mail});

                // Ajoutez le sujet de l'e-mail
                intentmail.putExtra(Intent.EXTRA_SUBJECT, "Bienvenue");

                // Ajoutez le contenu de l'e-mail
                intentmail.putExtra(Intent.EXTRA_TEXT, "Bienvenue sur notre application !");

                // Spécifiez le type de contenu de l'e-mail (dans ce cas, du texte)
                intentmail.setType("text/plain");

                // Lancez l'activité d'envoi d'e-mail
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Envoyer un e-mail"));
                } else {
                    Toast.makeText(this, "Aucune application de messagerie n'est installée sur cet appareil.", Toast.LENGTH_SHORT).show();
                }

                startActivity(intent);
            });

        }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
}