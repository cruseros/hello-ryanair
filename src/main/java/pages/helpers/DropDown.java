package pages.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DropDown {

    private static void selectRandomElement(WebElement webElement, List<WebElement> webElements) {
        webElement.click();
        DriverWait.until(ExpectedConditions.visibilityOf(webElements.get(0)));
        WebElements.getRandomElement(webElements).click();
    }

    private static void selectNonRandomElement(WebElement webElement, List<WebElement> webElements, String elementText) {
        webElement.click();

        for (WebElement element : webElements) {
            if (element.getText().equals(elementText)) {
                element.click();
                break;
            }
        }
    }

    public static void selectElement(WebElement webElement, List<WebElement> webElements, String elementText) {
        if (elementText.equals("")) {
            selectRandomElement(webElement, webElements);
        } else {
            selectNonRandomElement(webElement, webElements, elementText);
        }
    }
}
