package selenium;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.helpers.Driver;

import java.util.concurrent.TimeUnit;

public class Common {

    //------------------------------------------ Constants

    private static String BASE_URL = "https://www.ryanair.com/";
    private static String LOCALE_URL = "ie/en/";
    private static int WAITING_TIME = 15;

    //------------------------------------------ Methods

    @Before
    public static void setUpDriver() {

        Driver.getInstance().setDriver(new ChromeDriver());

        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME, TimeUnit.SECONDS);

        driver.get(BASE_URL + LOCALE_URL);
    }

    //TODO:@After
    public static void teardown() {
        WebDriver driver = Driver.getDriver();
        driver.quit();
    }
}
