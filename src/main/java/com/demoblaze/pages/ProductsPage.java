package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ProductsPage extends BasePage {

    private final By productNameLink = By.xpath("//a[@class='hrefch']");
    private final By userName = By.id("nameofuser");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String clickOneVisibleProduct() {
        String name = "";
        List<WebElement> products = driver.findElements(productNameLink);
        for (WebElement product : products) {
            if (product.isDisplayed()) {
                name = product.getText();
                click(product, "Click on " + product.getText() + " laptop");
                break;
            }
        }

        return name;
    }
    public boolean isUserNameDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(driver -> {
                try {
                    return driver.findElement(userName).isDisplayed();
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            });
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
    public WebElement getUserNameText(){
        return driver.findElement(userName);
    }

}
