package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

public class BookingExtrasSeatsDialog extends PageObject {

    @FindBy(xpath = "//*[contains(@id, 'ngdialog') and @role='alertdialog']//div[contains(@class, 'dialog-aside')]")
    private WebElement bookingExtrasSeatsDialog;

    @FindBy(xpath = "//core-icon[contains(@class, 'dialog-close')]")
    private WebElement crossButton;

    @FindBy(xpath = "//span[contains(@translate, 'close_seatmap')]")
    private WebElement noThanksButton;

    public BookingExtrasSeatsDialog() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingExtrasSeatsDialog));
    }

    private boolean isElementPresent(WebElement webElement) {
        try{
            DriverWait.until(ExpectedConditions.visibilityOf(webElement));

            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public BookingExtrasPage closeDialog() {
        // There is an A/B
        if (isElementPresent(noThanksButton)) {
            noThanksButton.click();
        } else {
            crossButton.click();
        }

        return new BookingExtrasPage();
    }
}
