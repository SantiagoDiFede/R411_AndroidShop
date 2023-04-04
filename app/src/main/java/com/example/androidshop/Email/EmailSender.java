package com.example.androidshop.Email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    // Adresse e-mail et mot de passe de l'expéditeur
    private final String username="malrega60@gmail.com";
    private final String password="qiqwvewdnyxbavoi";

    // Configuration des propriétés pour l'envoi d'e-mails
    private final Properties props;

    public EmailSender() {

        // Configuration des propriétés pour l'envoi d'e-mails via Gmail
        props = new Properties();
        props.put("mail.smtp.auth", "true"); // Authentification requise
        props.put("mail.smtp.starttls.enable", "true"); // Utilisation de TLS
        props.put("mail.smtp.host", "smtp.gmail.com"); // Serveur SMTP Gmail
        props.put("mail.smtp.port", "587"); // Port SMTP Gmail
    }

    // Méthode pour envoyer un e-mail
    public void sendEmail(String recipient, String subject, String body) throws MessagingException {

        // Création d'une session pour l'envoi d'e-mails
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        // Création du message à envoyer
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username)); // Adresse e-mail de l'expéditeur
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient)); // Adresse e-mail du destinataire
        message.setSubject(subject); // Sujet de l'e-mail
        message.setText(body); // Contenu de l'e-mail

        // Envoi de l'e-mail
        Transport.send(message);
    }
}
