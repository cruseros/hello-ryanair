package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class LoginRegisterDialog extends PageObject {

    @FindBy(xpath="//*[contains(@class, 'signup-modal')]//*[@ng-switch-when='login']")
    private WebElement loginRegisterDialogRegisterMode;

    @FindBy(xpath = "//*[@ng-switch-when='login']//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-switch-when='login']//input[@name='password']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-switch-when='login']//button[@type='submit']")
    private WebElement logInButton;

    @FindBy(xpath = "//span[contains(@class, 'username') and @data-hj-suppress]")
    private WebElement loggedUserNameLabel;

//mytest@fleckens.hu
    //A123456a.
    public LoginRegisterDialog() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(loginRegisterDialogRegisterMode));
    }
}
