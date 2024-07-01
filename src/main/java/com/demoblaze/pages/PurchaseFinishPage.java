package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseFinishPage extends BasePage {

    private final By headerMessage = By.xpath("//div[contains(@class,'sweet-alert')]/h2");
    private final By contentMessage = By.xpath("//div[contains(@class,'sweet-alert')]/p");

    public PurchaseFinishPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderMessage() {
        return driver.findElement(headerMessage).getText();
    }
    public String getContentMessage() {
        return driver.findElement(contentMessage).getText();
    }
}
