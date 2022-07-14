package com.example.tamogatchi.goals.main;


/**
 * Created by karanjaswani on 1/12/18.
 */

public class MyGoalsItem
{
    private int id;
    private String name;
    private String shortdesc;
    private double health;
    private int image;

    public MyGoalsItem(int id, String name, String shortdesc, double health, int image) {
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
