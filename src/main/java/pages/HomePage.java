package pages;

import domain.Search;
import domain.TripType;
import org.joda.time.DateTime;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.Field;
import pages.helpers.PageObject;

public class HomePage extends PageObject {

    @FindBy(id = "home")
    private WebElement homepage;

    @FindBy(id = "lbl-flight-search-type-return")
    private WebElement returnTripTypRadioButton;

    @FindBy(id = "lbl-flight-search-type-one-way")
    private WebElement oneWayTripTypeRadioButton;

    @FindBy(xpath = "//input[@aria-labelledby='label-airport-selector-from']")
    private WebElement departureAirportField;

    @FindBy(xpath = "//input[@aria-labelledby='label-airport-selector-to']")
    private WebElement destinationAirportField;

    @FindBy(xpath = "//*[@translate='common.buttons.continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@name='startDate']/..//input[@name = 'dateInput0']")
    private WebElement flyOutDayField;

    @FindBy(xpath = "//input[@name='startDate']/..//input[@name = 'dateInput1']")
    private WebElement flyOutMonthField;

    @FindBy(xpath = "//input[@name='startDate']/..//input[@name = 'dateInput2']")
    private WebElement flyOutYearField;

    @FindBy(xpath = "//input[@name='endDate']/..//input[@name = 'dateInput0']")
    private WebElement flyBackDayField;

    @FindBy(xpath = "//input[@name='endDate']/..//input[@name = 'dateInput1']")
    private WebElement flyBackMonthField;

    @FindBy(xpath = "//input[@name='endDate']/..//input[@name = 'dateInput2']")
    private WebElement flyBackYearField;

    @FindBy(xpath = "//*[@translate='common.buttons.lets_go']")
    private WebElement letsGoButton;

    public HomePage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(homepage));
    }

    private void fillDateField(DateTime date, WebElement weDay, WebElement weMonth, WebElement weYear) {
        Field.write(weDay, String.valueOf(date.getDayOfMonth()));
        Field.write(weMonth, String.valueOf(date.getMonthOfYear()));
        Field.write(weYear, String.valueOf(date.getYear()));
    }

    private void fillSearch(Search search) {
        selectTripType(search.getTripType());

        Field.write(departureAirportField, search.getOrigin());
        Field.write(destinationAirportField, search.getDestination());

        continueButton.click();

        DriverWait.until(ExpectedConditions.visibilityOf(flyOutDayField));
        fillDateField(search.getOutboundDate(), flyOutDayField, flyOutMonthField, flyOutYearField);
        if (search.getTripType().equals(TripType.RETURN_WAY)) {
            fillDateField(search.getInboundDate(), flyBackDayField, flyBackMonthField, flyBackYearField);
        }
    }

    private void selectTripType(TripType tripType) {
        DriverWait.until(ExpectedConditions.visibilityOf(returnTripTypRadioButton));

        WebElement we = tripType.equals(TripType.ONE_WAY) ? oneWayTripTypeRadioButton :
                tripType.equals(TripType.RETURN_WAY) ? returnTripTypRadioButton : null;

        if (we != null) {
            we.click();
        }
    }

    private BookingSelectionPage clickInLetsGoButton() {
        letsGoButton.click();
        return new BookingSelectionPage();
    }

    public BookingSelectionPage performSearch(Search search) {
        fillSearch(search);
        letsGoButton.click();

        return clickInLetsGoButton();
    }
}
