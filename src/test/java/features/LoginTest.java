package features;

import com.demoblaze.helpers.JsonTestData;
import com.demoblaze.models.Buyer;
import com.demoblaze.models.UserCredential;
import com.demoblaze.pages.*;
import com.demoblaze.pages.common.LeftPanelPage;
import com.demoblaze.pages.common.NavigationBarPage;
import features.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.demoblaze.enums.Categories.LAPTOPS;
import static com.demoblaze.enums.NavigationOptions.*;

public class LoginTest extends BaseTest {

    public static String userDataPath = "resources/testdata/login/";

    @Test(description = "User registered Login to product shopping site", dataProvider = "userCredentialsDataProvider")
    public void userRegisteredLoginTest(UserCredential userCredential) {
        new NavigationBarPage(driver).clickOn(LOGIN);
        LogInPage loginPage = new LogInPage(driver);

        ProductsPage productsPage = loginPage.loginAs(userCredential.getUserName(), userCredential.getPassword());
        System.out.println("LOGIN DE TEST");
        Assert.assertTrue(productsPage.isUserNameDisplayed(), "El nombre de usuario no está visible.");
        Assert.assertEquals(productsPage.getUserNameText().getText(), "Welcome "+userCredential.getUserName());
    }

    @Test(description = "User no registered Login to product shopping site", dataProvider = "userCredentialsDataProvider")
    public void userNoRegisteredLoginTest(UserCredential userCredential) throws InterruptedException {
        new NavigationBarPage(driver).clickOn(LOGIN);
        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginAs(userCredential.getUserName(),userCredential.getPassword());
        System.out.println("LOGIN DE TEST");
        Assert.assertTrue(loginPage.isErrorMessageVisible(),"Credenciales validas");
    }

    @DataProvider(name = "userCredentialsDataProvider")
    public Object[] userDataProvider() throws FileNotFoundException {
        return JsonTestData.helper().getTestDataFromJson(userDataPath + "user-credentials.json", UserCredential.class);
    }
}
