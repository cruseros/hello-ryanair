package domain;

import org.apache.commons.lang.RandomStringUtils;

public class ContactDetails {
    private String country;
    private String phoneNumber;

    public ContactDetails() {
        this.country = "";
        this.phoneNumber = RandomStringUtils.randomNumeric(9);
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
