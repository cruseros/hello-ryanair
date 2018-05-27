package pages.helpers;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static Driver ourInstance = new Driver();
    private static WebDriver driver;
    public static Driver getInstance() {
        return ourInstance;
    }

    private Driver() {
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }
}
