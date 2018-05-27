package pages.helpers;

import org.openqa.selenium.WebElement;

public class Field {

    private WebElement webElement;

    public Field(WebElement webElement) {
        this.webElement = webElement;
    }

    public void write(String data) {
        webElement.clear();
        webElement.sendKeys(data);
    }
}
