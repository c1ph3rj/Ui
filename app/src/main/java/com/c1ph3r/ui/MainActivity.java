package com.c1ph3r.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.c1ph3r.ui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding MAIN;
    boolean isDarkMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MAIN = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(MAIN.getRoot());


        // Code for Light/Dark mode.

       MAIN.darkMode.setProgress(0.5f);

       MAIN.darkMode.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(isDarkMode){
                  MAIN.darkMode.setMinAndMaxProgress(0,0.5f);
                  MAIN.darkMode.playAnimation();
                  isDarkMode = false;
               }else{
                   MAIN.darkMode.setMinAndMaxProgress(0.5f,1f);
                   MAIN.darkMode.playAnimation();
                   isDarkMode = true;
               }
           }
       });


    }
}