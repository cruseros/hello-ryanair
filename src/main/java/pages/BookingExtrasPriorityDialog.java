package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class BookingExtrasPriorityDialog extends PageObject {

    @FindBy(id="ngdialog2")
    private WebElement bookingExtrasPriorityDialog;

    @FindBy(xpath="//button[contains(@class, 'popup-msg__button--cancel')]")
    private WebElement noThanksButton;

    public BookingExtrasPriorityDialog() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingExtrasPriorityDialog));
    }

    public BookingPaymentPage closeDialog() {
        DriverWait.until(ExpectedConditions.visibilityOf(noThanksButton));

        noThanksButton.click();

        return new BookingPaymentPage();
    }
}
