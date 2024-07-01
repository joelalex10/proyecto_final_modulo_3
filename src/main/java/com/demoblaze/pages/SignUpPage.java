package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {
    private By userInput = By.id("sign-username");
    private By passWordInput = By.id("sign-password");
    private By loginButton = By.xpath("//div[@id='signInModal']//button[contains(text(),'Sign up')]");


    public SignUpPage(WebDriver driver) {
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
    public void signUpAs(String user, String passWord){
        typeUserName(user);
        typePassWord(passWord);
        clickOnLoginButton();
    }
    public void clickOnLoginButton(){
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

}
