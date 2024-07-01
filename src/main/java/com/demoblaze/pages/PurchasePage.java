package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage extends BasePage {

    private final By nameInput = By.id("name");
    private final By countryInput = By.id("country");
    private final By cityInput = By.id("city");
    private final By creditCardInput = By.id("card");
    private final By monthInput = By.id("month");
    private final By yearInput = By.id("year");
    private final By purchaseBtn = By.xpath("//button[text()='Purchase']");

    @Getter
    private final String name;
    private final String country;
    private final String city;
    @Getter
    private final String card;
    private final String month;
    private final String year;

    public PurchasePage(WebDriver driver, String name, String country, String city, String card, String month, String year) {
        super(driver);
        this.name = name;
        this.country = country;
        this.city = city;
        this.month = month;
        this.year = year;
        this.card = card;
    }

    public void fillInfo() {
        clearAndType(nameInput, name, "Enter name for place order " + name, false);
        clearAndType(cityInput, city, "Enter city for place order " + city, false);
        clearAndType(countryInput, country, "Enter country for place order " + country, false);
        clearAndType(creditCardInput, card, "Enter card for place order " + card, false);
        clearAndType(monthInput, month, "Enter month for place order " + month, false);
        clearAndType(yearInput, year, "Enter year for place order " + year, false);

        screenShot("Enter buyer information");
    }

    public void fillUserDataAndBuy() throws InterruptedException {
        fillInfo();
        if(!driver.findElement(purchaseBtn).isDisplayed()) zoomOut();
        click(purchaseBtn, "Click on Purchase button");
    }

}
