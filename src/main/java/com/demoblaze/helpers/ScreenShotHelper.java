package com.demoblaze.helpers;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotHelper {

    public static String takeScreenShot(WebDriver driver) {
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        return takesScreenshot.getScreenshotAs(OutputType.BASE64);
    }

    public static void takeScreenShotAndAdToHTMLReport(WebDriver driver, Status status, String details) {
        String imageBase64 = takeScreenShot(driver);

        ReportManager.getInstance().getTest().log(status, details,
                MediaEntityBuilder.createScreenCaptureFromBase64String(imageBase64).build());
    }




}
