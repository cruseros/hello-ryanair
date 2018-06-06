package pages.helpers;

import org.openqa.selenium.WebElement;

public class Field {

    public static void write(WebElement webElement, String data) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(data);
    }
}
