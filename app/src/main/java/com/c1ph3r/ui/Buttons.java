package com.c1ph3r.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.c1ph3r.ui.databinding.ActivityButtonsBinding;

public class Buttons extends AppCompatActivity {

    private ActivityButtonsBinding BUTTONS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View Binding.
        BUTTONS = ActivityButtonsBinding.inflate(getLayoutInflater());
        setContentView(BUTTONS.getRoot());



    }
}