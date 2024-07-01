package features.common;

import com.aventstack.extentreports.Status;
import com.demoblaze.helpers.ReportManager;
import com.demoblaze.helpers.ScreenShotHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static com.demoblaze.webdriver.WebDriverFactory.getDriver;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger log = LogManager.getLogger(BaseTest.class);



    @BeforeSuite
    public static void setupSuite() throws Exception {
        ReportManager.init("Reports", "DemoBlaze Automation Report");
    }

    @BeforeMethod
    @Parameters({"url", "browser"})
    public void setup(Method method, String url, String browser) throws Exception {
        ReportManager.getInstance().startTest(method.getName());
        driver = getDriver(browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {

        try {
            switch (iTestResult.getStatus()) {
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incompleto");
            }

            if (iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null) {
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.FAIL, "Failure image");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(1000);
            if (driver != null)
                driver.quit();
            log.info("Closing the webdriver");
        }
    }


    @AfterSuite
    public static void tearDownSuite() {
        ReportManager.getInstance().flush();
    }

    public void screenShot(String step){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, step);
    }
}
