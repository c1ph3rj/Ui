package com.c1ph3r.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.c1ph3r.ui.databinding.ActivityButtonsBinding;

public class Buttons extends AppCompatActivity {

    int btnSelected;
    private ActivityButtonsBinding BUTTONS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View Binding.
        BUTTONS = ActivityButtonsBinding.inflate(getLayoutInflater());
        setContentView(BUTTONS.getRoot());

        // Method for Animated radio button.
        customRadioButton();

    }

    private void customRadioButton() {
        BUTTONS.animatedRadioButton1.setOnClickListener(OnClickOfBtn1 -> {
            if(btnSelected == 0){
                System.out.println("4 \n\n\n\n");
                BUTTONS.animatedRadioButton1.playAnimation();
            }else if(btnSelected == BUTTONS.animatedRadioButton1.getId()){
                System.out.println("5 \n\n\n\n");
                BUTTONS.animatedRadioButton1.setSpeed(1);
                BUTTONS.animatedRadioButton1.playAnimation();
            }else {
                System.out.println("6 \n\n\n\n");
                LottieAnimationView animRadioBtn = findViewById(btnSelected);
                animRadioBtn.setSpeed(-1);
                animRadioBtn.playAnimation();
                BUTTONS.animatedRadioButton1.setSpeed(1);
                BUTTONS.animatedRadioButton1.playAnimation();
            }
            btnSelected = BUTTONS.animatedRadioButton1.getId();
        });

        BUTTONS.animatedRadioButton2.setOnClickListener(OnClickOfBtn2 -> {
            if(btnSelected == 0){
                BUTTONS.animatedRadioButton2.playAnimation();
            }else if(btnSelected == BUTTONS.animatedRadioButton2.getId()){
                BUTTONS.animatedRadioButton1.setSpeed(1);
                BUTTONS.animatedRadioButton2.playAnimation();
            }else {
                LottieAnimationView animRadioBtn = findViewById(btnSelected);
                animRadioBtn.setSpeed(-1);
                animRadioBtn.playAnimation();
                BUTTONS.animatedRadioButton2.setSpeed(1);
                BUTTONS.animatedRadioButton2.playAnimation();
            }
            btnSelected = BUTTONS.animatedRadioButton2.getId();
        });
    }

}