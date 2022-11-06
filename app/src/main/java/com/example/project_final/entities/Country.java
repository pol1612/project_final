package com.example.project_final.entities;

public class Country {

    private String name;
    private int city;
    private boolean europe;

    public Country(String nom, int població, boolean europe) {
        this.name = nom;
        this.city = població;
        this.europe = europe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public boolean isEurope() {
        return europe;
    }

    public void setEurope(boolean europe) {
        this.europe = europe;
    }

    public String toString() { return name + ", Població:" + city + " " + "Europeu? " + europe; }
}
