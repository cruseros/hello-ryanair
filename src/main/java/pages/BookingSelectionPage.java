package pages;

import domain.TripType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.PageObject;

import java.util.List;
import java.util.logging.Logger;

public class BookingSelectionPage extends PageObject {

    private static final Logger logger = Logger.getLogger(BookingSelectionPage.class.getName());

    @FindBy(id = "booking-selection")
    private WebElement bookingSelectionpage;

    @FindBys(@FindBy(xpath = "//*[@id='outbound']//*[contains(@class,'flight-header__min-price')]//*[contains(@class, 'flights-table-price__price')]"))
    private List<WebElement> outboundPriceButtons;

    @FindBys(@FindBy(xpath = "//*[@id='inbound']//*[contains(@class,'flight-header__min-price')]//*[contains(@class, 'flights-table-price__price')]"))
    private List<WebElement> inboundsPriceButtons;

    @FindBy(xpath = "//*[@id='outbound']//*[contains(@class, 'standard')]//*[contains(@class, 'flights-table-fares__fare-radio')]")
    private WebElement outboundRegularFareRadioButton;

    @FindBy(xpath = "//*[@id='inbound']//*[contains(@class, 'standard')]//*[contains(@class, 'flights-table-fares__fare-radio')]")
    private WebElement inboundRegularFareRadioButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public BookingSelectionPage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingSelectionpage));
    }

    private WebElement getRandomElement(List<WebElement> webElements) {
        int randomPosition = (int) (Math.random() * (webElements.size()));

        return webElements.get(randomPosition);
    }

    private void selectRandomBound(List<WebElement> prices, WebElement regularFare) {
        DriverWait.until(ExpectedConditions.visibilityOf(prices.get(0)));

        getRandomElement(prices).click();

        DriverWait.until(ExpectedConditions.visibilityOf(regularFare));

        regularFare.click();
    }

    public void selectRandomOutbound() {
        selectRandomBound(outboundPriceButtons, outboundRegularFareRadioButton);
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
