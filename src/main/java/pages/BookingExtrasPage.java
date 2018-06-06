package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class BookingExtrasPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class, 'extras-panel') and contains(@class, 'container')]")
    private WebElement bookingExtrasPage;

    @FindBy(xpath = "//section[@id='booking-selection']//*[contains(@class, 'core-btn-block')]")
    private WebElement checkOutButton;

    public BookingExtrasPage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingExtrasPage));
    }

    public BookingExtrasPriorityDialog clickInCheckOutButton() {
        checkOutButton.click();

        return new BookingExtrasPriorityDialog();
    }
}
