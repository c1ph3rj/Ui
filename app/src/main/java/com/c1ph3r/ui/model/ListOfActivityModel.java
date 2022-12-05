package com.c1ph3r.ui.model;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;

public class ListOfActivityModel {
    private Intent intent;
    private String Title;
    private Drawable TitleImg;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Drawable getTitleImg() {
        return TitleImg;
    }

    public void setTitleImg(Drawable titleImg) {
        TitleImg = titleImg;
    }
}
