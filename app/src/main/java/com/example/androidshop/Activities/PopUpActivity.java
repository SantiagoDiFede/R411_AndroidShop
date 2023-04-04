package com.example.androidshop.Activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidshop.Email.UserEmail;
import com.example.androidshop.R;

public class PopUpActivity extends Activity {

    private LinearLayout popupLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);
        Intent intent = getIntent();
        String mail = intent.getStringExtra("mail");
        // Get the popup layout
        TextView textView = findViewById(R.id.textView);
        textView.setText("Merci de votre commande! Le mail de confirmation a été envoyé à " + UserEmail.getInstance().getEmail() +". On espère vous revoir bientôt!");

        popupLayout = findViewById(R.id.popup_layout);

        // Commence avec le popup layout caché
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(popupLayout, View.SCALE_X, 0f, 1f),
                ObjectAnimator.ofFloat(popupLayout, View.SCALE_Y, 0f, 1f),
                ObjectAnimator.ofFloat(popupLayout, View.ALPHA, 0f, 1f)
        );
        animatorSet.setDuration(800);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.start();
    }


}
