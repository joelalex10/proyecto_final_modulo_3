package com.demoblaze.pages.common;

import com.demoblaze.enums.NavigationOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePage {

    public NavigationBarPage(WebDriver driver) {
        super(driver);
    }
    public void clickOn(NavigationOptions option) {
        driver.findElement(By.xpath(option.getXpath())).click();
    }

}
