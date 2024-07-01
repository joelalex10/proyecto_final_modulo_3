package com.demoblaze.pages;

import com.demoblaze.pages.common.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    @Getter
    private ProductsTablePage table;
    private final By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {
        super(driver);
        table = new ProductsTablePage(driver);
    }

    public void clickPlaceOrder() {
        click(placeOrderBtn, "Click on Place Order button");
    }
}

