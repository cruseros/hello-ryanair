package pages.helpers;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait {
    private static final int WAITING_TIME = 25;

    public static void until(ExpectedCondition expectedCondition) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), WAITING_TIME);
        wait.until(expectedCondition);
    }
}
