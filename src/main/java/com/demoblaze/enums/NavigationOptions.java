package com.demoblaze.enums;

public enum NavigationOptions {

    HOME("Home "),
    CONTACT("Contact "),
    CART("Cart"),
    LOGIN("Log in"),
    SIGNUP("Sign up"),
    WELCOME("Welcome");

    private String description;

    NavigationOptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String getXpath(){ return "//a[@class='nav-link' and text()='" + description + "']"; }
    public String getXpath(String value){ return "//a[@class='nav-link' and text()='" + description + " " + value + "']"; }
}
