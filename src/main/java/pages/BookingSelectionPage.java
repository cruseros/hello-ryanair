package pages;

import domain.TripType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;
import pages.helpers.WebElements;

import java.util.List;
import java.util.logging.Logger;

public class BookingSelectionPage extends PageObject {

    @FindBy(id = "booking-selection")
    private WebElement bookingSelectionpage;

    @FindBys(@FindBy(xpath = "//*[@id='outbound']//*[contains(@class,'flight-header__min-price')]//*[contains(@class, 'flights-table-price__price')]"))
    private List<WebElement> outboundPriceButtons;

    @FindBys(@FindBy(xpath = "//*[@id='inbound']//*[contains(@class,'flight-header__min-price')]//*[contains(@class, 'flights-table-price__price')]"))
    private List<WebElement> inboundsPriceButtons;

    @FindBy(xpath = "//*[@id='outbound']//*[contains(@class, 'standard')]")
    private WebElement outboundRegularFareRadioBox;

    @FindBy(xpath = "//*[@id='inbound']//*[contains(@class, 'standard')]")
    private WebElement inboundRegularFareRadioButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    private static final Logger logger = Logger.getLogger(BookingSelectionPage.class.getName());

    public BookingSelectionPage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingSelectionpage));
    }

    private void selectRandomBound(List<WebElement> prices, WebElement regularFare) {
        DriverWait.until(ExpectedConditions.visibilityOf(prices.get(0)));

        WebElements.getRandomElement(prices).click();

        DriverWait.until(ExpectedConditions.visibilityOf(regularFare));

        regularFare.click();
    }

    public void selectRandomOutbound() {
        selectRandomBound(outboundPriceButtons, outboundRegularFareRadioBox);
    }

    public void selectRandomInbound() {
        selectRandomBound(inboundsPriceButtons, inboundRegularFareRadioButton);
    }

    private BookingExtrasSeatsDialog clickInContinueButton() {
        DriverWait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        return new BookingExtrasSeatsDialog();
    }

    public BookingExtrasSeatsDialog doGenericBooking(TripType tripType) {
        selectRandomOutbound();
        if (tripType.equals(TripType.RETURN_WAY)) {
            selectRandomInbound();
        }

        return clickInContinueButton();
    }
}
