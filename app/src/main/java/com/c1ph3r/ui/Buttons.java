package com.c1ph3r.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.c1ph3r.ui.databinding.ActivityButtonsBinding;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class Buttons extends AppCompatActivity {

    int btnSelected;
    private ActivityButtonsBinding BUTTONS;
    private ArrayList<Integer> SelectedChip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View Binding.
        BUTTONS = ActivityButtonsBinding.inflate(getLayoutInflater());
        setContentView(BUTTONS.getRoot());

        // Method for Animated radio button.
        customRadioButton();

        // Method for Chip Buttons.
        chipButton();

    }

    private void chipButton() {
        BUTTONS.ChipButtons.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                SelectedChip = new ArrayList<>();
                SelectedChip.addAll(BUTTONS.ChipButtons.getCheckedChipIds());
                BUTTONS.CheckedChips.removeAllViews();
                for(Integer SelectedChipId: SelectedChip){
                    Chip button = findViewById(SelectedChipId);
                    Chip ChipButton = new Chip(Buttons.this, null, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice);
                    ChipButton.setText(button.getText());
                    ChipButton.setCloseIcon(AppCompatResources.getDrawable(Buttons.this, R.drawable.close_ic));
                    ChipButton.setChecked(true);
                    BUTTONS.CheckedChips.addView(ChipButton);
                }
            }
        });

        BUTTONS.CheckedChips.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                SelectedChip = new ArrayList<>();
                SelectedChip.addAll(BUTTONS.CheckedChips.getCheckedChipIds());
                for(Integer SelectedChipId: SelectedChip){
                    Chip button = findViewById(SelectedChipId);
                    Chip ChipButton = new Chip(Buttons.this, null, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice);
                    ChipButton.setText(button.getText());
                    BUTTONS.CheckedChips.addView(ChipButton);
            }
        }
    });
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