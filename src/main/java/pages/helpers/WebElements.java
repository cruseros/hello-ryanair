package pages.helpers;

import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElements {

    public static WebElement getRandomElement(List<WebElement> webElements) {
        int randomPosition = (int) (Math.random() * (webElements.size()));

        return webElements.get(randomPosition);
    }
}
