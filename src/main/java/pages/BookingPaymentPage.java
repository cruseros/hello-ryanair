package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class BookingPaymentPage extends PageObject {

    @FindBy(id="ngdialog1")
    private WebElement bookingPaymentPage;

    @FindBy(className="login-register")
    private WebElement loginRegisterSection;

    @FindBy(xpath="//class[@ui-sref='login']")
    private WebElement loginButton;

    public BookingPaymentPage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingPaymentPage));
    }

    public void login() {
        DriverWait.until(ExpectedConditions.visibilityOf(loginRegisterSection));

        loginButton.click();
    }
}
