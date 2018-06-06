package pages;

import domain.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.*;

public class LoginRegisterDialog extends PageObject {

    @FindBy(xpath = "//*[contains(@class, 'signup-modal')]")
    private WebElement loginRegisterDialog;

    @FindBy(xpath = "//*[contains(@class, 'signup-modal')]//*[@ng-switch-when='login']")
    private WebElement registerModeDialog;

    @FindBy(xpath = "//*[@ng-switch-when='login']//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-switch-when='login']//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@ng-switch-when='login']//button[@type='submit']")
    private WebElement logInButton;

    @FindBy(xpath = "//span[contains(@class, 'username') and @data-hj-suppress]")
    private WebElement loggedUserNameLabel;

    public LoginRegisterDialog() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(loginRegisterDialog));
    }

    private void fillLogin(Login login) {
        Field.write(emailField, login.getEmail());
        Field.write(passwordField, login.getPassword());
    }

    public void login() {
        DriverWait.until(ExpectedConditions.visibilityOf(registerModeDialog));

        Login login = new Login(new Credentials());
        fillLogin(login);

        logInButton.click();

        DriverWait.until(ExpectedConditions.visibilityOf(loggedUserNameLabel));
    }
}
