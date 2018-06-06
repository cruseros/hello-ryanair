package pages;

import org.apache.commons.lang.RandomStringUtils;
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

    public void fillRandomPaxInfo() {
        DropDown.selectRandomElement(titleDropDown, titleDropDownOptions);
        Field.write(firstName, RandomStringUtils.randomAlphabetic(7));
        Field.write(lastName, RandomStringUtils.randomAlphabetic(7));
    }

    public void fillRandomContactDetails() {
        DropDown.selectRandomElement(countryDropDown, countryDropDownOptions);
        Field.write(phoneNumber, RandomStringUtils.randomNumeric(9));
    }

    public void fillCreditCard(String cardNumber, String expiryMonth, String expiryYear, String securityCode) {
        creditCardRadioButton.click();
        Field.write(this.cardNumber, cardNumber.replaceAll("\\s",""));
        DropDown.selectRandomElement(cardTypeDropDown, cardTypeDropDownOptions);
        DropDown.selectElement(expiryMonthDropDown, expiryMonthDropDownOptions, expiryMonth);
        DropDown.selectElement(expiryYearDropDown, expiryYearDropDownOptions, expiryYear);
        Field.write(this.securityCode, securityCode);
        Field.write(cardHolder, RandomStringUtils.randomAlphabetic(7));
    }

    public void fillRandomBillingInfo() {
        Field.write(address1Field, RandomStringUtils.randomAlphabetic(10));
        Field.write(address2Field, RandomStringUtils.randomAlphabetic(10));
        Field.write(cityField, RandomStringUtils.randomAlphabetic(10));
        Field.write(zipCodeField, RandomStringUtils.randomNumeric(5));
        DropDown.selectRandomElement(billingCountryDropDown, billingCountryDropDownOptions);
        acceptConditionsCheckbox.click();
    }

    public void clickInPayNowButton() {
        payNowButton.click();
    }

    public void isFailedPaymentDialogDisplayed() {
        DriverWait.until(ExpectedConditions.visibilityOf(paymentDeclinedMessageBox));
    }
}
