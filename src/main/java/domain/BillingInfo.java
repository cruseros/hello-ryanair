package domain;

import org.apache.commons.lang.RandomStringUtils;

public class BillingInfo {
    private String addressField1;
    private String addressField2;
    private String city;
    private String zipCode;
    private String country;
    private boolean acceptConditions;

    public BillingInfo() {
        this.addressField1 = RandomStringUtils.randomAlphabetic(10);
        this.addressField2 = RandomStringUtils.randomAlphabetic(10);
        this.city = RandomStringUtils.randomAlphabetic(10);
        this.zipCode = RandomStringUtils.randomAlphabetic(5);
        this.country = "";
        this.acceptConditions = true;
    }

    public String getAddressField1() {
        return addressField1;
    }

    public String getAddressField2() {
        return addressField2;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public boolean isAcceptConditions() {
        return acceptConditions;
    }
}
