package com.example.tamogatchi.friends.main;

import android.content.Intent;
import android.view.View;

import com.example.tamogatchi.R;

/**
 * Created by karanjaswani on 1/12/18.
 */

public class AddFriendsItem {
    private int id;
    private String name;
    private String shortdesc;
    private double health;
    private int image;

    public AddFriendsItem(int id, String name, String shortdesc, double health, double time, int image) {
        this.id = id;
        this.name = name;
        this.shortdesc = shortdesc;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public String getShortdesc() {
        return shortdesc;
    }


    public int getImage() {
        return image;
    }

}
