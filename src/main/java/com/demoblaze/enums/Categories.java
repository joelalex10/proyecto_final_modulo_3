package com.demoblaze.enums;

public enum Categories {

    PHONES("Phones"),
    LAPTOPS("Laptops"),
    MONITORS("Monitors");

    private String description;

    Categories(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String getXpath(){ return "//a[@class='list-group-item' and text()='" + description + "']"; }
}
