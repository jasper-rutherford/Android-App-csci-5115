package com.example.tamogatchi.dressingroom;

/**
 * Created by karanjaswani on 1/12/18.
 */

public class ClothingItem
{
    private int id;
    private String name;
    private String shortdesc;
    private int image;

    public ClothingItem(int id, String name, String shortdesc, int image) {
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
