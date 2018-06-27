package com.example.sayone.testone.model;

import android.graphics.drawable.Drawable;

public class ImageListModel {

    Drawable img_drawable;
    String txt;

    public ImageListModel(Drawable img_drawable, String txt) {
        this.img_drawable = img_drawable;
        this.txt = txt;
    }

    public Drawable getImg_drawable() {
        return img_drawable;
    }

    public String getTxt() {
        return txt;
    }
}
