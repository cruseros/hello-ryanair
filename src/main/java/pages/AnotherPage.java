package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class AnotherPage extends PageObject {

    @FindBy(id="ngdialog1")
    private WebElement anotherPage;

    public AnotherPage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(anotherPage));
    }
}
