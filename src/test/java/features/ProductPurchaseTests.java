package features;

import com.demoblaze.helpers.JsonTestData;
import com.demoblaze.models.Buyer;
import com.demoblaze.pages.*;
import com.demoblaze.pages.common.LeftPanelPage;
import com.demoblaze.pages.common.NavigationBarPage;
import features.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.demoblaze.enums.Categories.LAPTOPS;
import static com.demoblaze.enums.NavigationOptions.CART;

public class ProductPurchaseTests extends BaseTest {

    public static String userDataPath = "resources/testdata/purchase/";
    public static String headerMessage = "Thank you for your purchase!";
    public static String messageExpected = "Please fill out Name and Creditcard.";

    @Test(description = "A laptop is successfully bought", dataProvider = "userDataDataProvider")
    public void SuccessProductPurchase(Buyer user) throws InterruptedException {

        new LeftPanelPage(driver).clickOn(LAPTOPS);
        new ProductsPage(driver).clickOneVisibleProduct();
        new ProductPage(driver).addToCart();

        new NavigationBarPage(driver).clickOn(CART);
        new CartPage(driver).clickPlaceOrder();

        PurchasePage purchasePage = new PurchasePage(driver, user.getName(), user.getCountry(), user.getCity(), user.getCard(), user.getMonth(), user.getYear());
        purchasePage.fillUserDataAndBuy();

        PurchaseFinishPage confirmationPage = new PurchaseFinishPage(driver);

        screenShot("Purchase confirmation message is visible");
        Assert.assertEquals(confirmationPage.getHeaderMessage(), headerMessage);
        Assert.assertTrue(confirmationPage.getContentMessage().contains(purchasePage.getCard()));
        Assert.assertTrue(confirmationPage.getContentMessage().contains(purchasePage.getName()));
    }

    @DataProvider(name = "userDataDataProvider")
    public Object[] userDataProvider() throws FileNotFoundException {
        return JsonTestData.helper().getTestDataFromJson(userDataPath + "user-data.json", Buyer.class);
    }


}

