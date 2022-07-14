package com.example.tamogatchi.friends.main;


import com.example.tamogatchi.R;

/**
 * Created by karanjaswani on 1/12/18.
 */

public class MyFriendsItem{
    private int id;
    private String name;
    private String shortdesc;
    private double health;
    private int image;

    public MyFriendsItem(int id, String name, String shortdesc, double health, int image) {
        this.id = id;
        this.name = name;
        this.shortdesc = shortdesc;
        this.health = health;
        this.image = image;;
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

    public double getRating() {
        return health;
    }

    public int getImage() {
        return image;
    }
}
