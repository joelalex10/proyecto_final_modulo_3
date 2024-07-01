package com.demoblaze.pages.common;

import com.aventstack.extentreports.Status;
import com.demoblaze.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    WebDriverWait wait;
    private final boolean takeScreenShot = true;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clearAndType(By selector, String text, String step, boolean shot){
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(text);
        screenShot(step, shot);
    }

    public void clearAndType(By selector, String value, String step){
        clearAndType(selector, value, step, takeScreenShot);
    }

    public void click(By selector, String step, boolean shot){
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        driver.findElement(selector).click();
        screenShot(step, shot);
    }

    public void click(By selector, String step){
        click(selector, step, takeScreenShot);
    }

    public void click(WebElement element, String step){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        screenShot(step, takeScreenShot);
    }

    public void screenShot(String stepText, boolean takeScreenShot){
        if (takeScreenShot) ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, stepText);
    }

    public void screenShot(String stepText){
        screenShot(stepText, takeScreenShot);
    }

    public void acceptAlert() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    public void zoomOut() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '80%';");
    }
}
