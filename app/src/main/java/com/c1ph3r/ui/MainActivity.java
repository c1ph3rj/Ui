package com.c1ph3r.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

import com.c1ph3r.ui.adapter.custom_list_adapter;
import com.c1ph3r.ui.databinding.ActivityMainBinding;
import com.c1ph3r.ui.databinding.CustomListItemBinding;
import com.c1ph3r.ui.model.ListOfActivityModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declaring required variables.
    private ActivityMainBinding MAIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ViewBinding.
        MAIN = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(MAIN.getRoot());

        // Method to change the THEME.
        setUiMode();

        // To setup ListView of Activities.
        setListView();

    }

    // To initialize the list view of components.
    private void setListView() {
        Intent intent;
        // Creating new ArrayList to store the ListOfComponents.
        ArrayList<ListOfActivityModel> listOfActivityModels = new ArrayList<>();
        ListOfActivityModel ActivityModel = new ListOfActivityModel();
        // Adding Field For buttons.
        ActivityModel.setTitle("List Of Buttons");
        ActivityModel.setTitleImg(AppCompatResources.getDrawable(this, R.drawable.buttons_ic));
        intent = new Intent(this, Buttons.class);
        ActivityModel.setIntent(intent);
        listOfActivityModels.add(ActivityModel);

        // Initializing the adapter with the required arraylist.
        custom_list_adapter adapter = new custom_list_adapter(this,listOfActivityModels);
        // Adding the adapter to the ListView.
        MAIN.listOfActivities.setAdapter(adapter);
    }// End of setListView().

    // To identify and change the theme of the ui.
    private void setUiMode() {
        // Using shared pref.
        SharedPreferences sharedPreferences = getSharedPreferences("DarkModeEnabled", MODE_PRIVATE);
        // If the user already enabled dark mode in the app it returns true.
        if(sharedPreferences.getBoolean("DarkMode", false)){
            // Altering the fields and setting the application theme to dark mode.
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            // Setting animation to the dark mode button
            MAIN.darkMode.setMinAndMaxProgress(0,0.5f);
            MAIN.darkMode.setSpeed(1);
            // Playing the animation.
            MAIN.darkMode.playAnimation();
        }
        // If the user does not enabled the dark mode the setting the mode to light mode.
        else{
            // Changing the theme to light.
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            // Changing the animation to represent light theme.
            MAIN.darkMode.setMinAndMaxProgress(0, 0.5f);
            MAIN.darkMode.setSpeed(-1);
            // Playing the animation.
            MAIN.darkMode.playAnimation();
        }
        // Shared pref to store the data.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // On click of a dark mode button changing the theme.
        MAIN.darkMode.setOnClickListener(view -> {
            // storing the shared pref value based on the dark mode.
            editor.putBoolean("DarkMode", AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO);
            // Intent to start the same activity to initialize the changes.
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_out , R.anim.fade_in);
            startActivity(intent, options.toBundle());
            finish();
            // Applying the changes.
            editor.apply();
        });
    }// End of the setUiMode().


}