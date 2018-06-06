package pages;

import domain.BillingInfo;
import domain.ContactDetails;
import domain.CreditCard;
import domain.PassengerDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.helpers.DriverWait;
import pages.helpers.DropDown;
import pages.helpers.Field;
import pages.helpers.PageObject;

import java.util.List;

public class BookingPaymentPage extends PageObject {
    @FindBy(className = "payment-page")
    private WebElement bookingPaymentPage;

    @FindBy(xpath = "//*[contains(@id, 'title')]")
    private WebElement titleDropDown;

    @FindBys(@FindBy(xpath = "//*[contains(@id, 'title')]/option[not(@disabled)]"))
    private List<WebElement> titleDropDownOptions;

    @FindBy(xpath = "//*[contains(@name, 'firstName')]")
    private WebElement firstName;

    @FindBy(xpath = "//*[contains(@name, 'lastName')]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@name='phoneNumberCountry']")
    private WebElement countryDropDown;

    @FindBys(@FindBy(xpath = "//*[@name='phoneNumberCountry']//option[not(@disabled)]"))
    private List<WebElement> countryDropDownOptions;

    @FindBy(xpath = "//input[@name = 'phoneNumber']")
    private WebElement phoneNumber;

    @FindBy(id = "CC")
    private WebElement creditCardRadioButton;

    @FindBy(xpath = "//*[contains(@id, 'cardNumber')]")
    private WebElement cardNumber;

    @FindBy(xpath = "//*[@name='cardType']")
    private WebElement cardTypeDropDown;

    @FindBys(@FindBy(xpath = "//*[@name='cardType']//option[not(@disabled)]"))
    private List<WebElement> cardTypeDropDownOptions;

    @FindBy(xpath = "//*[@name='expiryMonth']")
    private WebElement expiryMonthDropDown;

    @FindBys(@FindBy(xpath = "//*[@name='expiryMonth']//option[not(@disabled)]"))
    private List<WebElement> expiryMonthDropDownOptions;

    @FindBy(xpath = "//*[@name='expiryYear']")
    private WebElement expiryYearDropDown;

    @FindBys(@FindBy(xpath = "//*[@name='expiryYear']//option[not(@disabled)]"))
    private List<WebElement> expiryYearDropDownOptions;

    @FindBy(xpath = "//*[@name = 'securityCode']")
    private WebElement securityCode;

    @FindBy(xpath = "//input[contains(@class, 'cardholder')]")
    private WebElement cardHolder;

    @FindBy(id = "billingAddressAddressLine1")
    private WebElement address1Field;

    @FindBy(id = "billingAddressAddressLine2")
    private WebElement address2Field;

    @FindBy(id = "billingAddressCity")
    private WebElement cityField;

    @FindBy(id = "billingAddressPostcode")
    private WebElement zipCodeField;

    @FindBy(id = "billingAddressCountry")
    private WebElement billingCountryDropDown;

    @FindBys(@FindBy(xpath = "//*[@id = 'billingAddressCountry']//option[not(@disabled)]"))
    private List<WebElement> billingCountryDropDownOptions;

    @FindBy(xpath = "//label[contains(@for, 'acceptTerms')]")
    private WebElement acceptConditionsCheckbox;

    @FindBy(xpath = "//form//button[contains(@translate, 'pay_now')]")
    private WebElement payNowButton;

    @FindBy(xpath = "//prompt[contains(@text, 'error_explain_declined')]")
    private WebElement paymentDeclinedMessageBox;

    public BookingPaymentPage() {
        super();

        DriverWait.until(ExpectedConditions.visibilityOf(bookingPaymentPage));
    }

    public void fillPassengerDetails(PassengerDetails passengerDetails) {
        DropDown.selectElement(titleDropDown, titleDropDownOptions, passengerDetails.getTitle());
        Field.write(firstName, passengerDetails.getFirstName());
        Field.write(lastName, passengerDetails.getLastName());
    }

    public void fillContactDetails(ContactDetails contactDetails) {
        DropDown.selectElement(countryDropDown, countryDropDownOptions, contactDetails.getCountry());
        Field.write(phoneNumber, contactDetails.getPhoneNumber());
    }

    public void fillCreditCard(CreditCard creditCard) {
        creditCardRadioButton.click();
        Field.write(this.cardNumber, creditCard.getCardNumber());
        DropDown.selectElement(cardTypeDropDown, cardTypeDropDownOptions, creditCard.getCardType());
        DropDown.selectElement(expiryMonthDropDown, expiryMonthDropDownOptions, creditCard.getExpiryMonth());
        DropDown.selectElement(expiryYearDropDown, expiryYearDropDownOptions, creditCard.getExpiryYear());
        Field.write(this.securityCode, creditCard.getSecurityCode());
        Field.write(cardHolder, creditCard.getCardHolder());
    }

    public void fillBillingInfo(BillingInfo billingInfo) {
        Field.write(address1Field, billingInfo.getAddressField1());
        Field.write(address2Field, billingInfo.getAddressField2());
        Field.write(cityField, billingInfo.getCity());
        Field.write(zipCodeField, billingInfo.getZipCode());
        DropDown.selectElement(billingCountryDropDown, billingCountryDropDownOptions, billingInfo.getCountry());
        if(billingInfo.isAcceptConditions()) { acceptConditionsCheckbox.click(); }
    }

    public void clickInPayNowButton() {
        payNowButton.click();
    }

    public void isFailedPaymentDialogDisplayed() {
        DriverWait.until(ExpectedConditions.visibilityOf(paymentDeclinedMessageBox));
    }
}
