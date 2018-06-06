package domain;

import org.apache.commons.lang.RandomStringUtils;

public class CreditCard {
    private String cardNumber;
    private String cardType;
    private String expiryMonth;
    private String expiryYear;
    private String securityCode;
    private String cardHolder;

    public CreditCard(String cardNumber, String expiryMonth, String expiryYear, String securityCode) {
        this.cardNumber = cardNumber.replaceAll("\\s", "");
        this.cardType = "";
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.securityCode = securityCode;
        this.cardHolder = RandomStringUtils.randomAlphabetic(7);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getCardHolder() {
        return cardHolder;
    }
}
