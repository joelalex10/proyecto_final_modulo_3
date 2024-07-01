package features;

import com.demoblaze.pages.*;
import com.demoblaze.pages.common.LeftPanelPage;
import com.demoblaze.pages.common.NavigationBarPage;
import features.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoblaze.enums.Categories.LAPTOPS;
import static com.demoblaze.enums.NavigationOptions.CART;

public class AddProductsToCartTests extends BaseTest {


    @Test(description = "Product selected is added to Cart")
    public void addOneProductToCart() throws InterruptedException {
        new LeftPanelPage(driver).clickOn(LAPTOPS);
        new ProductsPage(driver).clickOneVisibleProduct();
        ProductPage product = new ProductPage(driver);
        product.addToCart();

        new NavigationBarPage(driver).clickOn(CART);
        CartPage cartPage = new CartPage(driver);

        String productNameOnTable = cartPage.getTable().getProductNameByRow("1");
        String productPriceOnTable = cartPage.getTable().getProductPriceByRow("1");

        screenShot("Product selected is present on Cart");
        Assert.assertEquals(productNameOnTable, product.getProductName());
        Assert.assertTrue(product.getProductPrice().contains(productPriceOnTable));

    }

}
