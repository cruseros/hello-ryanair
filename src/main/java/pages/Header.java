package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class Header extends PageObject {

    @FindBy(id = "ryanair-navbar")
    private WebElement header;

    @FindBy(xpath = "//*[@ui-sref='login' and contains(@class, 'core-btn-secondary')]")
    private WebElement loginButton;

    public Header() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(header));
    }

    public LoginRegisterDialog clickInLoginButon() {
        loginButton.click();

        return new LoginRegisterDialog();
    }
}
