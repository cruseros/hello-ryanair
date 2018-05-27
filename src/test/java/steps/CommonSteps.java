package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Search;
import domain.SearchPaxs;
import domain.TripType;
import pages.*;

import java.util.logging.Logger;

public class CommonSteps {

    //------------------------------------------ Properties

    private static final Logger logger = Logger.getLogger(CommonSteps.class.getName());

    //------------------------------------------ Methods

    @When("^I make a booking from \"([A-Z]+)\" to \"([A-Z]+)\" on (\\d{2}/\\d{2}/\\d{4}) for (\\d+) adults and (\\d+) child$")
    public void makeBooking(String departure, String destination, String outboundDate, int numAdults, int numChild) {

        HomePage homePage = new HomePage();

        BookingSelectionPage bookingSelectionPage =
                homePage.performSearch(new Search(TripType.ONE_WAY, departure, destination, outboundDate, new SearchPaxs(numAdults, numChild)));

        BookingExtrasSeatsDialog bookingExtrasSeatsDialog = bookingSelectionPage.doGenericBooking(TripType.ONE_WAY);

        BookingExtrasPage bookingExtrasPage = bookingExtrasSeatsDialog.closeDialog();

        BookingPaymentPage bookingPaymentPage = bookingExtrasPage.clickInCheckOutButton();





        logger.info("Making a " + TripType.ONE_WAY + " booking");
        logger.info(departure + " " + destination + " " + outboundDate + " " + numAdults + " " + numChild);
    }

    @When("^I pay for booking with card details \"([\\d\\s]+)\", \"(\\d{2}/\\d{2})\" and \"(\\d+)\"$")
    public void i_pay_for_booking_with_card_details_and() {
    }

    @Then("^I should get payment declined message$")
    public void i_should_get_payment_declined_message() {
    }
}
