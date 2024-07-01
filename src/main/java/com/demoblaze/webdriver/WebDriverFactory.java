package com.demoblaze.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                return new ChromeDriverCreator().createWebDriver();
            case "firefox":
                return new FirefoxDriverCreator().createWebDriver();
            default:
                throw new Exception(browser + " no soportado");
        }
    }
}
