package driver;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.helpers.Driver;

import java.util.concurrent.TimeUnit;

public class Init {

    //------------------------------------------ Constants

    private static String BASE_URL = "https://www.ryanair.com/";
    private static String LOCALE_URL = "ie/en/";
    private static int WAITING_TIME = 15;

    //------------------------------------------ Methods

    @Before
    public static void setUpDriver() {

        Driver.getInstance().setDriver(new ChromeDriver());

        WebDriver driver = Driver.getDriver();
        personalizeDriver(driver);

        goToUrl(driver,BASE_URL + LOCALE_URL);
    }

    private static void personalizeDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAITING_TIME, TimeUnit.SECONDS);
    }

    private static void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }
}
