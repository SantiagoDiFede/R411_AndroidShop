package com.example.androidshop.Email;

public class UserEmail {
    private static UserEmail instance;
    private String email;

    private UserEmail() {}

    /**
     * Retourne l'instance unique de l'adresse email.
     * Crée une nouvelle instance si elle n'existe pas encore.
     *
     * @return Instance unique de l'adresse email.
     */
    public static synchronized UserEmail getInstance() {
        if (instance == null) {
            instance = new UserEmail();
        }
        return instance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
