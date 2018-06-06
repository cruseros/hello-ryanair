package driver;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import pages.helpers.Driver;

public class TearDown {

    @After
    public static void teardown() {
        WebDriver driver = Driver.getDriver();
        driver.quit();
    }
}
