package pages;

import domain.Search;
import domain.SearchPaxs;
import domain.TripType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.Field;
import pages.helpers.PageObject;

public class HomePage extends PageObject {

    @FindBy(id="home")
    private WebElement homepage;

    @FindBy(id="lbl-flight-search-type-return")
    private WebElement returnTripTypRadioButton;

    @FindBy(id="lbl-flight-search-type-one-way")
    private WebElement oneWayTripTypeRadioButton;

    @FindBy(xpath="//input[@aria-labelledby='label-airport-selector-from']")
    private WebElement departureAirportField;

    @FindBy(xpath="//input[@aria-labelledby='label-airport-selector-to']")
    private WebElement destinationAirportField;

    @FindBy(xpath="//*[@translate='common.buttons.continue']")
    private WebElement continueButton;

    @FindBy(xpath="//div[@name='startDate']/.//*[@name='dateInput0']")
    private WebElement flyOutDateField;

    @FindBy(xpath="//input[@name='endDate']/..//*[@name='dateInput0']")
    private WebElement flyBackDateField;

    @FindBy(xpath="//div[@ng-switch-default]/label[@id='label-pax-input']/../div[@class='value']")
    private WebElement paxInputDropDrownButton;

    @FindBy(xpath="//*[@value='paxInput.adults']/div[@class='details']")
    private WebElement adultsNumberLabel;

    @FindBy(xpath="//*[@value='paxInput.children']/div[@class='details']")
    private WebElement childrenNumberLabel;

    @FindBy(xpath="//*[@translate='common.buttons.lets_go']")
    private WebElement letsGoButton;

    public HomePage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(homepage));
    }

    private void fillSearch(Search search) {
        selectTripType(search.getTripType());

        new Field(departureAirportField).write(search.getOrigin());
        new Field(destinationAirportField).write(search.getDestination());

        continueButton.click();

        new Field(flyOutDateField).write(search.getOutboundDate());
        if(search.getTripType().equals(TripType.RETURN_WAY)) {
            new Field(flyBackDateField).write(search.getInboundDate());
        }

        selectNumberPaxs(search.getSearchPaxs());
    }

    private void selectTripType(TripType tripType) {
        DriverWait.until(ExpectedConditions.visibilityOf(returnTripTypRadioButton));

        WebElement we = tripType.equals(TripType.ONE_WAY) ? oneWayTripTypeRadioButton :
                tripType.equals(TripType.RETURN_WAY) ? returnTripTypRadioButton : null;

        if(we != null) {
            we.click();
        }
    }

    private void selectNumberPaxs(SearchPaxs searchPaxs) {

    }

    private BookingSelectionPage clickInLetsGoButton(){
        letsGoButton.click();
        return new BookingSelectionPage();
    }

    public BookingSelectionPage performSearch(Search search) {
        fillSearch(search);
        letsGoButton.click();

        return clickInLetsGoButton();
    }
}
