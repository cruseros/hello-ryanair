package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class BookingExtrasPriorityDialog extends PageObject {

    @FindBy(id="ngdialog4")
    private WebElement bookingExtrasPriorityDialog;

    @FindBy(xpath="//class[@id='booking-selection']//*[contains(@class, 'core-btn-block')]")//;popup-msg__close-icon
    private WebElement checkOutButton;

    public BookingExtrasPriorityDialog() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingExtrasPriorityDialog));
    }
}
