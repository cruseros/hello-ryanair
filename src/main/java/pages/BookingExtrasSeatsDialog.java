package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class BookingExtrasSeatsDialog extends PageObject {

    @FindBy(id="ngdialog1")
    private WebElement bookingExtrasSeatsDialog;

    @FindBy(xpath="//*[@translate='trips.seats.modal.close_seatmap']")
    private WebElement noThanksButton;

    public BookingExtrasSeatsDialog() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingExtrasSeatsDialog));
    }

    public BookingExtrasPage closeDialog() {
        DriverWait.until(ExpectedConditions.visibilityOf(noThanksButton));

        noThanksButton.click();

        return new BookingExtrasPage();
    }
}
