package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsTablePage extends BasePage {

    private final String PICTURE_COLUMN = "1";
    private final String TITLE_COLUMN = "2";
    private final String PRICE_COLUMN = "3";

    private final By productsTable = By.id("tbodyid");
    private final String nameProductCell = "//tr[@class='success'][row]/td[(" + TITLE_COLUMN + ")]";
    private final String priceProductCell = "//tr[@class='success'][row]/td[(" + PRICE_COLUMN + ")]";


    public ProductsTablePage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameByRow(String row) {
        return driver.findElement(By.xpath(nameProductCell.replace("row", row))).getText();
    }

    public String getProductPriceByRow(String row) {
        return driver.findElement(By.xpath(priceProductCell.replace("row", row))).getText();
    }

}

