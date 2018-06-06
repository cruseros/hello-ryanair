package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.*;
import pages.*;

import java.util.logging.Logger;

public class CommonSteps {

    //------------------------------------------ Properties

    private static final Logger logger = Logger.getLogger(CommonSteps.class.getName());

    //------------------------------------------ Methods

    @Given("^that the user is logged in$")
    public void checkNotLoggedUser() {

        Header header = new Header();

        LoginRegisterDialog loginRegisterDialog = header.clickInLoginButon();

        loginRegisterDialog.login();
    }

    @When("^I make a booking from \"([A-Z]+)\" to \"([A-Z]+)\" on (\\d{2}/\\d{2}/\\d{4})$")
    public void makeBooking(String departure, String destination, String outboundDate) {

        HomePage homePage = new HomePage();

        BookingSelectionPage bookingSelectionPage =
                homePage.performSearch(new Search(TripType.ONE_WAY, departure, destination, outboundDate));

        BookingExtrasSeatsDialog bookingExtrasSeatsDialog = bookingSelectionPage.doGenericBooking(TripType.ONE_WAY);

        BookingExtrasPage bookingExtrasPage = bookingExtrasSeatsDialog.closeDialog();

        BookingExtrasPriorityDialog bookingExtrasPriorityDialog = bookingExtrasPage.clickInCheckOutButton();

        bookingExtrasPriorityDialog.closeDialog();

        logger.info("Making a " + TripType.ONE_WAY + " booking");
        logger.info(departure + " " + destination + " " + outboundDate);
    }

    @When("^I pay for booking with card details \"([\\d\\s]+)\", \"(\\d{2})/(\\d{4})\" and \"(\\d+)\"$")
    public void completePaymentInfo(String cardNumber, String expiryMonth, String expiryYear, String securityCode) {

        BookingPaymentPage bookingPaymentPage = new BookingPaymentPage();

        bookingPaymentPage.fillPassengerDetails(new PassengerDetails());
        bookingPaymentPage.fillContactDetails(new ContactDetails());
        bookingPaymentPage.fillCreditCard(new CreditCard(cardNumber, expiryMonth, expiryYear, securityCode));
        bookingPaymentPage.fillBillingInfo(new BillingInfo());

        bookingPaymentPage.clickInPayNowButton();
    }

    @Then("^I should get payment declined message$")
    public void checkPaymentDeclined() {

        BookingPaymentPage bookingPaymentPage = new BookingPaymentPage();

        bookingPaymentPage.isFailedPaymentDialogDisplayed();
    }
}
