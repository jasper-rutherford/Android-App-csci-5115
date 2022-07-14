package com.example.tamogatchi.dressingroom;


/**
 * Created by karanjaswani on 1/12/18.
 */

public class MyOutfitsItem
{
    private int id;
    private String name;
    private int image;

    public MyOutfitsItem(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
