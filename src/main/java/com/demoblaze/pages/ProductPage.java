package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    String productName;
    @Getter
    String productPrice;
    String productDescription;
    private final By productNameLbl = By.xpath("//h2[@class='name']");
    private final By productPriceLbl = By.xpath("//h3[@class='price-container']");
    private final By productDescriptionLbl = By.id("more-information");
    private final By addToCartBtn = By.xpath("//a[text()='Add to cart']");


    public ProductPage(WebDriver driver) {
        super(driver);
        productName = driver.findElement(productNameLbl).getText();
        productPrice = driver.findElement(productPriceLbl).getText();
        productDescription = driver.findElement(productDescriptionLbl).getText();
    }

    public String getProductName() { return productName; }

    public String getProductDescription() {
        return productDescription;
    }

    public void addToCart() {
        click(addToCartBtn, "Click on Add to Cart button" );
        try {
            acceptAlert();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
