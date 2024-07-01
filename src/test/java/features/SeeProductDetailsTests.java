package features;

import com.demoblaze.pages.*;
import com.demoblaze.pages.common.LeftPanelPage;
import features.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoblaze.enums.Categories.LAPTOPS;

public class SeeProductDetailsTests extends BaseTest {

    @Test(description = "Information details is showed for a Laptop selected")
    public void LaptopDetailsScreen() throws InterruptedException {
        new LeftPanelPage(driver).clickOn(LAPTOPS);

        String laptopNameSelected = new ProductsPage(driver).clickOneVisibleProduct();
        ProductPage product = new ProductPage(driver);

        screenShot("Check information details is showed for the Laptop selected ");

        Assert.assertEquals(product.getProductName(), laptopNameSelected);
        Assert.assertFalse(product.getProductPrice().isEmpty());
        Assert.assertFalse(product.getProductDescription().isEmpty());

    }

}
