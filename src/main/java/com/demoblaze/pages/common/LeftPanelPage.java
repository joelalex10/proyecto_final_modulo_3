package com.demoblaze.pages.common;

import com.demoblaze.enums.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftPanelPage extends BasePage {

    public LeftPanelPage(WebDriver driver) {
        super(driver);
    }
    public void clickOn(Categories option) {
        click(By.xpath(option.getXpath()),"Click on " + option.toString());
    }

}
