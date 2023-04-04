package com.example.androidshop;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        textView.setText("Merci de votre commande! le mail confirmation a été envoyé à " + mail);

        popupLayout = findViewById(R.id.popup_layout);

        // Start with the popup layout hidden
        popupLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Animate the popup window to appear in the center of the screen
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(popupLayout, View.SCALE_X, 0f, 1f),
                ObjectAnimator.ofFloat(popupLayout, View.SCALE_Y, 0f, 1f),
                ObjectAnimator.ofFloat(popupLayout, View.ALPHA, 0f, 1f)
        );
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.start();
    }
}
