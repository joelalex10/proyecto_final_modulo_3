package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage extends BasePage {
    private By userInput = By.id("loginusername");
    private By passWordInput = By.id("loginpassword");
    private By loginButton = By.xpath("//div[@id='logInModal']//button[text()='Log in']");


    public LogInPage(WebDriver driver) {
        super(driver);
    }
    public void typeUserName(String user){
        WebElement element = driver.findElement(userInput);
        element.sendKeys(user);
    }

    public void typePassWord(String passWord){
        WebElement element = driver.findElement(passWordInput);
        element.sendKeys(passWord);
    }
    public ProductsPage loginAs(String user, String passWord){
        typeUserName(user);
        typePassWord(passWord);
        return clickOnLoginButton();
    }
    public ProductsPage clickOnLoginButton(){
        WebElement element = driver.findElement(loginButton);
        element.click();
        return new ProductsPage(driver);
    }
    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
     }

}
